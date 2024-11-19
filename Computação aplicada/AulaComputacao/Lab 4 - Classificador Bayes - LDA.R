
# Remoção de qualquer variável do ambiente
rm(list=ls())

################################################################################
# 1. LEITURA DOS DADOS DE TREINAMENTO                                          #  
################################################################################
dados = read.csv("datatraining.txt",header=T, na.strings="?")
summary(dados)

################################################################################
# 2. PREPARAÇÃO DOS DADOS                                                      #
################################################################################

################################################################################
# 2.1. CONVERSÃO DOS RÓTULOS EM FACTOR                  
dados$Occupancy = factor(dados$Occupancy, labels=c("Não.Ocupado","Ocupado"))

################################################################################
# 2.2. DETECÇÃO E REMOÇÃO DOS OUTLIERS                                             
outliers = c()
for (i in 1:length(dados)) {
  if (class(dados[,i]) == "numeric") {
    outliers = c(outliers,which(dados[,i] %in% boxplot.stats(dados[,i])$out))
  }
}
outliers = unique(outliers) # remoção dos índices duplicados
dados = dados[-outliers,]
rm(outliers,i)

################################################################################
# 2.3. TRANSFORMAÇÃO DOS DADOS
library(lubridate)
# converter a string em uma representação interna
dados$date    = ymd_hms(dados$date) 
# Adicionar uma coluna chamada Minutos com os minutos corridos do dia
dados$Minutos = int_length(interval(date(dados$date),dados$date)) / 60.0 
# Adicionar uma coluna chamada DiaMes com o dia do mês
dados$DiaMes = day(date(dados$date))
dados$date   = NULL

################################################################################
# 2.4. SEPARAÇÃO DOS DADOS / RÓTULOS
rotulos = dados[,6] 
dados   = dados[,-6] 

################################################################################
# 2.5. NORMALIZAÇÃO DOS DADOS (Escore-Z)                                        
library(caret)
normalizacaoParametros = preProcess(dados,method = c("center","scale"))
dados = predict(normalizacaoParametros, dados)

################################################################################
# 2.6. SELEÇÃO DE CARACTERÍSTICAS - REMOÇÃO VIA CORRRELAÇÃO                      
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
# 3.2. SALVAR MODELO E PARÂMETROS
save(lda.modelo, file = "ocupacao.modelos")
save(normalizacaoParametros, indicesCorrelacaoForte, file = "ocupacao.parametros")

################################################################################
# 3.3. LIMPAR AS VARIÁVEIS DO AMBIENTE
rm(list = ls())

################################################################################
# 4. PROCESSO DE TESTE                                                         #
################################################################################

################################################################################
# 4.1. LEITURA DO MODELO / PARÂMETROS
load("ocupacao.modelos")
load("ocupacao.parametros")

################################################################################
# 4.1. LEITURA DOS DADOS DE TESTE
dados = read.csv("datatest.txt",header=T, na.strings="?")
summary(dados)

################################################################################
# 4.2. CONVERSÃO DOS RÓTULOS EM FACTOR                 
dados$Occupancy = factor(dados$Occupancy, labels=c("Não.Ocupado","Ocupado"))

################################################################################
# 4.3. TRANSFORMAÇÃO DOS DADOS
library(lubridate)
# converter a string em uma representação interna
dados$date    = ymd_hms(dados$date) 
# Adicionar uma coluna chamada Minutos com os minutos corridos do dia
dados$Minutos = int_length(interval(date(dados$date),dados$date)) / 60.0 
# Adicionar uma coluna chamada DiaMes com o dia do mês
dados$DiaMes = day(date(dados$date))
dados$date   = NULL

################################################################################
# 4.4. SEPARAÇÃO DOS DADOS / RÓTULOS
rotulos = dados[,6] 
dados   = dados[,-6] 

################################################################################
# 4.5. NORMALIZAÇÃO DOS DADOS (Escore-Z)                                        
library(caret)
dados = predict(normalizacaoParametros, dados)

################################################################################
# 4.6. SELEÇÃO DE CARACTERÍSTICAS                     
dados[,indicesCorrelacaoForte] = NULL

################################################################################
# 4.7. ESTIMAÇÃO DA CLASSE
lda.predicao = predict(lda.modelo,dados)

################################################################################
# 4.8. AVALIAÇÃO DE DESEMPENHO - MATRIZ DE CONFUSÃO
confusionMatrix(lda.predicao,rotulos, positive = "Ocupado")

################################################################################
# 4.9. AVALIAÇÃO DE DESEMPENHO - ROC
library(ROCR)
lda.probabilidades = predict(lda.modelo,dados,type="prob")
lda.predicao = prediction(lda.probabilidades[,2],rotulos)
roc = performance(lda.predicao,"tpr","fpr")
plot(roc,col='blue',main='ROC - LDA')
