library(gridExtra)
library(ggplot2)
library(lubridate)
library(caret)
library(corrplot)
library(GGally) 
library(mclust)
library(tictoc)
library(caret)

rm(list=ls())

setwd("C:\\Users\\Johnny\\Desktop\\")
dados = read.csv("Dados2.csv",header=T,na.strings="?",sep = ";",dec = ".")
summary(dados)

dados = na.omit(dados)

dados$class = factor(dados$class,
                     levels = 1:12, 
                     labels = c("Menor100","D100a200","D200a300","D300a400","D400a500","D500a600","D600a700","D700a800","D800a900","D900a1000","D1000a1500","Maior1500"))
summary(dados)
#retira coluna valor, usada apenas para o histograma
dados$valor = NULL 

barplot(summary(dados$class),col=c("green","blue"),ylab="Nº de amostras",main="Class",las=2)


rotulos = dados[,6] 
dados = dados[,-6] 

#Remoção de caracteristicas

matrizCorrelacao = cor(dados)
corrplot.mixed(matrizCorrelacao,lower.col="black")

#correlação acima de 0.70
indicesCorrelacaoForte = findCorrelation(matrizCorrelacao, cutoff=0.70)

#Remoção das variáveis que possuem correlação acima de 0.95 (com p-value < 0.05)
if (length(indicesCorrelacaoForte) > 0)
  dados[,indicesCorrelacaoForte] = NULL

#Cria particoes
set.seed(1)
indicesTreinamento = createDataPartition(rotulos, p = 2/3, list = FALSE)
dadosTreinamento   = dados[indicesTreinamento,]
rotulosTreinamento = rotulos[indicesTreinamento]
dadosTeste         = dados[-indicesTreinamento,]
rotulosTeste       = rotulos[-indicesTreinamento]
rm(dados)


#Remove outliers
outliers = c()
for (i in 1:length(dadosTreinamento)) {
  outliers = c(outliers,which(dadosTreinamento[,i] %in% boxplot.stats(dadosTreinamento[,i])$out))
}
outliers = unique(outliers) 
dadosTreinamento   = dadosTreinamento[-outliers,]
rotulosTreinamento = rotulosTreinamento[-outliers]
rm(outliers,i)

#Normaliza dados 
normalizacaoParametros = preProcess(dadosTreinamento,method = c("center","scale"))
dadosTreinamento = predict(normalizacaoParametros, dadosTreinamento)
dadosTeste       = predict(normalizacaoParametros, dadosTeste)
rm(normalizacaoParametros)


set.seed(1)
gmm.modelo = MclustDA(dadosTreinamento,rotulosTreinamento,verbose=FALSE)

set.seed(1)
# Define o n?mero de componentes para cada GMM
gmm.modelo.componentes = MclustDA(dadosTreinamento,
                                  rotulosTreinamento, 4,verbose=FALSE)

set.seed(1)
# Define o a matriz de covari?ncia como diagonal
gmm.modelo.modeloVVI = MclustDA(dadosTreinamento, rotulosTreinamento, 
                                modelNames = c("VVI"),verbose=FALSE)

set.seed(1)
# Define a matriz de covari?ncia completa
gmm.modelo.modeloVVV = MclustDA(dadosTreinamento,
                                rotulosTreinamento, 
                                modelNames = c("VVV"),verbose=FALSE)


#treino
library(doParallel)
numeroCores = detectCores(logical = FALSE) 
clusters = makePSOCKcluster(numeroCores)
registerDoParallel(clusters)


tic("Treinamento Rede Neural")
set.seed(1)
paramsTreinamento = trainControl(classProbs = TRUE)
tic("mlp")
mlp.modelo = train(dadosTreinamento, rotulosTreinamento,
                   trControl = paramsTreinamento,
                   method="mlp")
toc()

set.seed(1)
tic("nnet")
nnet.modelo = train(dadosTreinamento, rotulosTreinamento,
                    trControl = paramsTreinamento,
                    method="nnet")
toc()
toc()

stopCluster(clusters)


#Avaliacao

gmm.predicao              = predict(gmm.modelo,dadosTreinamento)
gmm.componentes.predicao  = predict(gmm.modelo.componentes,dadosTreinamento)
gmm.modeloVVI.predicao    = predict(gmm.modelo.modeloVVI,dadosTreinamento)
gmm.modeloVVV.predicao    = predict(gmm.modelo.modeloVVV,dadosTreinamento)
mlp.predicao              = predict(mlp.modelo,dadosTreinamento)
nnet.predicao             = predict(nnet.modelo,dadosTreinamento)

resultado.treinamento = data.frame(Classificador=character(), Acuracia=double(),
                                   AcuraciaInferior=double(), AcuraciaSuperior=double(),
                                   stringsAsFactors = FALSE)

res = confusionMatrix(gmm.predicao$classification,rotulosTreinamento)
resultado.treinamento[1,] = data.frame("GMM Default",res$overall["Accuracy"],
                                       res$overall["AccuracyLower"], 
                                       res$overall["AccuracyUpper"])

res = confusionMatrix(gmm.componentes.predicao$classification,rotulosTreinamento)
resultado.treinamento[2,] = data.frame("GMM 4 Componentes",res$overall["Accuracy"],
                                       res$overall["AccuracyLower"], 
                                       res$overall["AccuracyUpper"])

res = confusionMatrix(gmm.modeloVVI.predicao$classification,rotulosTreinamento)
resultado.treinamento[3,] = data.frame("GMM Diagonal",res$overall["Accuracy"],
                                       res$overall["AccuracyLower"], 
                                       res$overall["AccuracyUpper"])

res = confusionMatrix(gmm.modeloVVV.predicao$classification,rotulosTreinamento)
resultado.treinamento[4,] = data.frame("GMM Completo",res$overall["Accuracy"],
                                       res$overall["AccuracyLower"], 
                                       res$overall["AccuracyUpper"])

res = confusionMatrix(mlp.predicao,rotulosTreinamento)
resultado.treinamento[5,] = data.frame("MLP",res$overall["Accuracy"],
                                       res$overall["AccuracyLower"], 
                                       res$overall["AccuracyUpper"])

res = confusionMatrix(nnet.predicao,rotulosTreinamento)
resultado.treinamento[6,] = data.frame("NNET",res$overall["Accuracy"],
                                       res$overall["AccuracyLower"], 
                                       res$overall["AccuracyUpper"])

ggplot(resultado.treinamento, aes(Classificador, Acuracia)) + geom_point() + 
  geom_errorbar(aes(ymin=AcuraciaInferior , ymax=AcuraciaSuperior), width=.2,
                position=position_dodge(.9)) + ylim(0.1, 1) +
  ggtitle("Acur?cia do Treinamento") 

################################################################################
# 3. TESTE                                                                     #
################################################################################

################################################################################
# 3.1. AVALIA??O DE DESEMPENHO
gmm.predicao              = predict(gmm.modelo,dadosTeste)
gmm.componentes.predicao  = predict(gmm.modelo.componentes,dadosTeste)
gmm.modeloVVI.predicao    = predict(gmm.modelo.modeloVVI,dadosTeste)
gmm.modeloVVV.predicao    = predict(gmm.modelo.modeloVVV,dadosTeste)
mlp.predicao              = predict(mlp.modelo,dadosTeste)
nnet.predicao             = predict(nnet.modelo,dadosTeste)

resultado.teste = data.frame(Classificador=character(), Acuracia=double(),
                             AcuraciaInferior=double(), AcuraciaSuperior=double(),
                             stringsAsFactors = FALSE)

res = confusionMatrix(gmm.predicao$classification,rotulosTeste)
resultado.teste[1,] = data.frame("GMM Default",res$overall["Accuracy"],
                                 res$overall["AccuracyLower"], 
                                 res$overall["AccuracyUpper"])

res = confusionMatrix(gmm.componentes.predicao$classification,rotulosTeste)
resultado.teste[2,] = data.frame("GMM 4 Componentes",res$overall["Accuracy"],
                                 res$overall["AccuracyLower"], 
                                 res$overall["AccuracyUpper"])

res = confusionMatrix(gmm.modeloVVI.predicao$classification,rotulosTeste)
resultado.teste[3,] = data.frame("GMM Diagonal",res$overall["Accuracy"],
                                 res$overall["AccuracyLower"], 
                                 res$overall["AccuracyUpper"])

res = confusionMatrix(gmm.modeloVVV.predicao$classification,rotulosTeste)
resultado.teste[4,] = data.frame("GMM Completo",res$overall["Accuracy"],
                                 res$overall["AccuracyLower"], 
                                 res$overall["AccuracyUpper"])

res = confusionMatrix(mlp.predicao,rotulosTeste)
resultado.teste[5,] = data.frame("MLP",res$overall["Accuracy"],
                                 res$overall["AccuracyLower"], 
                                 res$overall["AccuracyUpper"])

res = confusionMatrix(nnet.predicao,rotulosTeste)
resultado.teste[6,] = data.frame("NNET",res$overall["Accuracy"],
                                 res$overall["AccuracyLower"], 
                                 res$overall["AccuracyUpper"])

ggplot(resultado.teste, aes(Classificador, Acuracia)) + geom_point() + 
  geom_errorbar(aes(ymin=AcuraciaInferior , ymax=AcuraciaSuperior), width=.2,
                position=position_dodge(.9)) + ylim(0.1, 1) +
  ggtitle("Acur?cia do Teste") 


