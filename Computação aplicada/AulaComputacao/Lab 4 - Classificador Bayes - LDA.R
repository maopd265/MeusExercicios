
# Remo��o de qualquer vari�vel do ambiente
rm(list=ls())

################################################################################
# 1. LEITURA DOS DADOS DE TREINAMENTO                                          #  
################################################################################
dados = read.csv("datatraining.txt",header=T, na.strings="?")
summary(dados)

################################################################################
# 2. PREPARA��O DOS DADOS                                                      #
################################################################################

################################################################################
# 2.1. CONVERS�O DOS R�TULOS EM FACTOR                  
dados$Occupancy = factor(dados$Occupancy, labels=c("N�o.Ocupado","Ocupado"))

################################################################################
# 2.2. DETEC��O E REMO��O DOS OUTLIERS                                             
outliers = c()
for (i in 1:length(dados)) {
  if (class(dados[,i]) == "numeric") {
    outliers = c(outliers,which(dados[,i] %in% boxplot.stats(dados[,i])$out))
  }
}
outliers = unique(outliers) # remo��o dos �ndices duplicados
dados = dados[-outliers,]
rm(outliers,i)

################################################################################
# 2.3. TRANSFORMA��O DOS DADOS
library(lubridate)
# converter a string em uma representa��o interna
dados$date    = ymd_hms(dados$date) 
# Adicionar uma coluna chamada Minutos com os minutos corridos do dia
dados$Minutos = int_length(interval(date(dados$date),dados$date)) / 60.0 
# Adicionar uma coluna chamada DiaMes com o dia do m�s
dados$DiaMes = day(date(dados$date))
dados$date   = NULL

################################################################################
# 2.4. SEPARA��O DOS DADOS / R�TULOS
rotulos = dados[,6] 
dados   = dados[,-6] 

################################################################################
# 2.5. NORMALIZA��O DOS DADOS (Escore-Z)                                        
library(caret)
normalizacaoParametros = preProcess(dados,method = c("center","scale"))
dados = predict(normalizacaoParametros, dados)

################################################################################
# 2.6. SELE��O DE CARACTER�STICAS - REMO��O VIA CORRRELA��O                      
dadosCorrelacao = cor(dados)

indicesCorrelacaoForte = findCorrelation(dadosCorrelacao, cutoff=0.95, verbose=T)
if (length(indicesCorrelacaoForte) > 0)
  dados[,indicesCorrelacaoForte] = NULL
rm(dadosCorrelacao)

################################################################################
# 3. PROCESSO DE TREINAMENTO                                                   #
################################################################################

################################################################################
# 3.1. TREINAMENTO DO CLASSIFICADOR
paramsTreinamento = trainControl(method = "none", classProbs  = TRUE)

lda.modelo = train(dados, 
                  rotulos,
                  trControl = paramsTreinamento,
                  method = "lda")

################################################################################
# 3.2. SALVAR MODELO E PAR�METROS
save(lda.modelo, file = "ocupacao.modelos")
save(normalizacaoParametros, indicesCorrelacaoForte, file = "ocupacao.parametros")

################################################################################
# 3.3. LIMPAR AS VARI�VEIS DO AMBIENTE
rm(list = ls())

################################################################################
# 4. PROCESSO DE TESTE                                                         #
################################################################################

################################################################################
# 4.1. LEITURA DO MODELO / PAR�METROS
load("ocupacao.modelos")
load("ocupacao.parametros")

################################################################################
# 4.1. LEITURA DOS DADOS DE TESTE
dados = read.csv("datatest.txt",header=T, na.strings="?")
summary(dados)

################################################################################
# 4.2. CONVERS�O DOS R�TULOS EM FACTOR                 
dados$Occupancy = factor(dados$Occupancy, labels=c("N�o.Ocupado","Ocupado"))

################################################################################
# 4.3. TRANSFORMA��O DOS DADOS
library(lubridate)
# converter a string em uma representa��o interna
dados$date    = ymd_hms(dados$date) 
# Adicionar uma coluna chamada Minutos com os minutos corridos do dia
dados$Minutos = int_length(interval(date(dados$date),dados$date)) / 60.0 
# Adicionar uma coluna chamada DiaMes com o dia do m�s
dados$DiaMes = day(date(dados$date))
dados$date   = NULL

################################################################################
# 4.4. SEPARA��O DOS DADOS / R�TULOS
rotulos = dados[,6] 
dados   = dados[,-6] 

################################################################################
# 4.5. NORMALIZA��O DOS DADOS (Escore-Z)                                        
library(caret)
dados = predict(normalizacaoParametros, dados)

################################################################################
# 4.6. SELE��O DE CARACTER�STICAS                     
dados[,indicesCorrelacaoForte] = NULL

################################################################################
# 4.7. ESTIMA��O DA CLASSE
lda.predicao = predict(lda.modelo,dados)

################################################################################
# 4.8. AVALIA��O DE DESEMPENHO - MATRIZ DE CONFUS�O
confusionMatrix(lda.predicao,rotulos, positive = "Ocupado")

################################################################################
# 4.9. AVALIA��O DE DESEMPENHO - ROC
library(ROCR)
lda.probabilidades = predict(lda.modelo,dados,type="prob")
lda.predicao = prediction(lda.probabilidades[,2],rotulos)
roc = performance(lda.predicao,"tpr","fpr")
plot(roc,col='blue',main='ROC - LDA')
