---
  title: "Comandos do Lab 1"
author: "Daniel Luis Notari"
date: "18/08/2022"
output:
  html_document:
  df_print: paged
pdf_document: default
word_document: default
---
  

## instalação de pacote
install.packages("caret", dependencies = TRUE)

## Para carregar um pacote
library(caret)

##retorna o diretório de trabalho atual
getwd() 

##Para definir o diretório de trabalho como o seu diretório atual
setwd("D:/Computação Aplicada I")

## chamar ajuda
?getwd

## números
typeof(5)
typeof(5L)
typeof(5i)

##Lógica (TRUE e T ou FALSE e F)
typeof(TRUE)
typeof(F)

##Caracteres (delimitadas por ‘ ou “)
"string"
'a'
typeof('a')
typeof("string")

##Vetor contém elementos do mesmo tipo (character, logical, double e integer)
vetor = c(1*pi, 2*pi, 3*pi, 4*pi)
print(vetor)
typeof(vetor)

##No caso de combinar tipos, a função c() converterá em um único tipo
vetor <- c(1, 2, 3, "a", "b", "c")
vetor

##Criar um vetor usando uma sequência
vetor = 1:8
print(vetor)

vetor = seq(from=1,to=10,by=2)
print(vetor)

##Obter o tamanho de um vetor
vetor = 1:8
length(vetor)

##Acessar um elemento (índice começa em 1)
vetor = 1:8
print(vetor[3])
print(vetor[6:8])

#Omitir posições (índices negativos)
print(vetor[-6:-8])

## possível selecionar elementos de um vetor utilizando expressões condicionais (utiliza indexação lógica)
vetor = 5:10
vetor[vetor>6 & vetor<9]
vetor>6 & vetor<9

##função which(), que retornar os índices que satisfazem a condição passada como parâmetro
vetor = 5:10
vetor[which(vetor>6 & vetor<9)]
which(vetor>6 & vetor<9)

## operação com vetores
v1 = 2:4
v2 = 5:7
v1
v2
v1+v2

v1 = 1:6
v2 = 3:4
v1
v2
v1+v2

##Para ordenar um vetor, deve-se utilizar a função sort()
sort(c(2,5,3,7))
sort(c(2,5,3,7), decreasing = T)

#Para acrescentar (append) um elemento no vetor, basta atribuir um valor no respectivo índice (caso o índice não for o próximo, o R insere NA no vetor)
v = 1:6
v[7] = 9
v

#listas podem armazenar elementos de tipos heterogêneos
lista = list(1, "abc", 1.23, TRUE)
str(lista)

##Duas formas de acessar os elementos
##[] : retorna uma lista 
lista[1]
typeof(lista[1])

##[[]] : retorna o elemento da lista 
lista[[1]]
typeof(lista[[1]])

##factors
classes = c("C1", "C2", "C3", "C2", "C1", "C3","C2", "C1", "C2")
typeof(classes)
print(classes)

classes = factor(classes)
typeof(classes)
print(classes)

classes = factor(classes, levels=c("C1", "C2", "C3", "C4"))
print(classes)

classes = factor(classes,levels=c("C1", "C2", "C3", "C4"),
                         labels=c("1", "2", "3", "4"))
print(classes)

classes = factor(c("C1", "C2", "C3","C2", "C1", "C3", "C2", "C1", "C2"))
classes[1]
classes[1:3]

##Identificar os níveis de um fator
levels(classes)

##Como inspecionar os conteúdos de um factor
summary(classes)
table(classes)

##O data frame é semelhante a uma lista de vetores de mesmo tamanho
data("iris") # carrega os dados iris
str(iris)

##Para obter os nomes das colunas, deve-se utilizar a função names()
names(iris)

#Informações acerca das dimensões da estrutura
ncol(iris)
nrow(iris)
dim(iris)

##Para acessar um elemento, o data frame deve ser acessado como se fosse uma matriz
x = iris[1,1]
typeof(x)
class(x)

##ou pelo nome da coluna (retorna um vetor)
x = iris$Sepal.Length
class(x)
typeof(x)

##Acessar como se fosse uma lista
x = iris["Sepal.Width"]
typeof(x)
class(x)

x = iris[["Sepal.Width"]]
typeof(x)
class(x)
x

##Acessar um subconjunto do data frame
sub = iris[1:2,]
typeof(sub)
class(sub)
sub

##Selecionar linhas com base em uma condição
sub = iris[iris$Sepal.Width<3.0,]
typeof(sub)
class(sub)
sub

##Remover colunas (para remover linhas, deve-se realizar a operação na dimensão das linhas)
dim(iris)
sub = iris[,-1] # Remove a coluna 1
dim(sub)

##Ou remover no próprio data frame
data(iris)
iris$Sepal.Length = NULL
ncol(iris)

##Adicionar uma coluna
iris$novacoluna = iris$Sepal.Width + iris$Petal.Length
str(iris)
print(iris$novacoluna)

