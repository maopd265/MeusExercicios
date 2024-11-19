#include<stdio.h>
#include<stdlib.h>
#include<string.h>

typedef struct cidades
{
    char *nome;
    struct cidades *next;
    /* data */
}cidades;

cidades* criarNodo(char *nome){
    cidades *nodo = malloc(sizeof(cidades));
    nodo->next=NULL;
    nodo->nome=strdup(nome);
    printf("\n\tCriacao do item na lista realizado com sucesso!\n");
    return nodo;
}
void inserir_item_na_lista(cidades *start,cidades *item){
    cidades *inicio = start;
    for (; inicio!=NULL;inicio=inicio->next)
    {
        if(inicio->next==NULL){
            inicio->next =item;
        }
    }
    
}
void escrever_lista(cidades *inicio){
    cidades *i = inicio;
    for (; i!=NULL; i=i->next)
    {
        printf("\n\tCidade:%s",i->nome);
    }
    
}

void liberar_lista(cidades *inicio) {
    cidades *tmp;
    while (inicio != NULL) {
        tmp = inicio;
        inicio = inicio->next;
        free(tmp->nome);
        free(tmp);
    }
}
int main(int argc, char const *argv[])
{
    char nome[100];
    cidades *inicio;
    
    printf("\n\tEscreva o nome da cidade:");
    fflush(stdout);
    scanf("%s",nome);
    if(strcmp(nome," ")!=0){
        inicio=criarNodo(nome);
    }
    while(strcmp(nome," ")!=0){
        scanf("%s",nome);
        cidades *nodo=criarNodo(nome);
        
        inserir_item_na_lista(&inicio,&nodo);
    }
    escrever_lista(inicio);
     liberar_lista(&inicio);
    return 0;
    
}

