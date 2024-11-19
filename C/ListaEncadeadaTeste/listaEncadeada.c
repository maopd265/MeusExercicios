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
    fflush(stdout);
    return nodo;
}
void inserir_item_na_lista(cidades *start,cidades *item){
    cidades *inicio = start;
    if (inicio==NULL)
    {
        printf("\nLista vazia!\n");
    }
    inicio=criarNodo(item);
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
    
    printf("Ola mundo!");
    char nome[100];
    cidades *inicio=NULL,*ini=NULL;
    
   
    
    
    if(fgets(nome,sizeof(nome),stdin)!=NULL){
        inicio=criarNodo(nome);
    }
    ini=inicio;
    for (; fgets(nome,sizeof(nome),stdin)!=NULL;ini=ini->next)
    {
      scanf("%s",nome);
        cidades *nodo=criarNodo(nome);
        
        inserir_item_na_lista(&inicio,&nodo);
        fflush(stdout);    /* code */
    }
    
    escrever_lista(&inicio);
     liberar_lista(&inicio);
    return 0;
}
