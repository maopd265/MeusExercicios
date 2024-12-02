
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

qda.modelo = train(dados, 
                   rotulos,
                   trControl = paramsTreinamento,
                   method = "qda")

nb.modelo = train(dados, 
                   rotulos,
                   trControl = paramsTreinamento,
                   tuneGrid  = data.frame(usekernel=FALSE, adjust=1, fL=0),
                   method = "nb")

################################################################################
# 3.2. SALVAR MODELO E PAR�METROS
save(lda.modelo,qda.modelo,nb.modelo, file = "ocupacao.modelos")
save(normalizacaoParametros, indicesCorrelacaoForte, file = "ocupacao.parametros")

################################################################################
# 3.3. AVALIAR DADOS DE TREINAMENTO
lda.predicao = predict(lda.modelo,dados)
qda.predicao = predict(qda.modelo,dados)
nb.predicao  = predict(nb.modelo,dados)

resultado.treinamento = data.frame(Classificador=character(),
                                   Acuracia=double(),
                                   Sensibilidade=double(),
                                   Especificidade=double(),
                                   Precisao=double(),
                                   F1=double(),
                                   stringsAsFactors = FALSE)

res = confusionMatrix(lda.predicao,rotulos, positive = "Ocupado")
resultado.treinamento[1,] = c("LDA",res$overall[1],res$byClass[1],
                              res$byClass[2],res$byClass[5],
                              res$byClass[7])

res = confusionMatrix(qda.predicao,rotulos, positive = "Ocupado")
resultado.treinamento[2,] = c("QDA",res$overall[1],res$byClass[1],
                              res$byClass[2],res$byClass[5],
                              res$byClass[7])

res = confusionMatrix(nb.predicao,rotulos, positive = "Ocupado")
resultado.treinamento[3,] = c("Naive Bayes",res$overall[1],res$byClass[1],
                              res$byClass[2],res$byClass[5],
                              res$byClass[7])
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
dados = read.csv("datatest2.txt",header=T, na.strings="?")
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
qda.predicao = predict(qda.modelo,dados)
nb.predicao  = predict(nb.modelo,dados)

################################################################################
# 4.8. AVALIA��O DE DESEMPENHO - MATRIZ DE CONFUS�O
resultado.teste = data.frame(Classificador=character(),
                              Acuracia=double(),
                              Sensibilidade=double(),
                              Especificidade=double(),
                              Precisao=double(),
                              F1=double(),
                              stringsAsFactors = FALSE)

res = confusionMatrix(lda.predicao,rotulos, positive = "Ocupado")
resultado.teste[1,] = c("LDA",res$overall[1],res$byClass[1],
                              res$byClass[2],res$byClass[5],
                              res$byClass[7])

res = confusionMatrix(qda.predicao,rotulos, positive = "Ocupado")
resultado.teste[2,] = c("QDA",res$overall[1],res$byClass[1],
                              res$byClass[2],res$byClass[5],
                              res$byClass[7])

res = confusionMatrix(nb.predicao,rotulos, positive = "Ocupado")
resultado.teste[3,] = c("Naive Bayes",res$overall[1],res$byClass[1],
                              res$byClass[2],res$byClass[5],
                              res$byClass[7])

################################################################################
# 4.9. AVALIA��O DE DESEMPENHO - ROC
library(ROCR)
lda.probabilidades = predict(lda.modelo,dados,type="prob")
lda.predicao = prediction(lda.probabilidades[,2],rotulos)
roc = performance(lda.predicao,"tpr","fpr")
plot(roc,col='blue',main='ROC')

qda.probabilidades = predict(qda.modelo,dados,type="prob")
qda.predicao = prediction(qda.probabilidades[,2],rotulos)
roc = performance(qda.predicao,"tpr","fpr")
plot(roc,col='red',add=TRUE)

nb.probabilidades = predict(nb.modelo,dados,type="prob")
nb.predicao = prediction(nb.probabilidades[,2],rotulos)
roc = performance(nb.predicao,"tpr","fpr")
plot(roc,col='green',add=TRUE)

legend("center",legend = c('LDA','QDA','Naive Bayes'),
       lty=1,col=c('blue','red','green'))
