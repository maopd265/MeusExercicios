#include<stdio.h>
#include<stdlib.h>
#include<string.h>
typedef struct listaStructCsv
{
    char *nome;
    char *rua;
    char *numero;
    struct listaStructCsv *next;
    /* data */
}listaStructCsv;

typedef struct pessoas{
    char *nome;
    struct pessoas *next;
}pessoas;

typedef struct enderecos{
    char *endereco;
    struct enderecos *next;
}enderecos;


void tokenLinha(char *linha, listaStructCsv **inicio) {
    listaStructCsv *listaPessoas = *inicio, *novaLista;
    char *token = strtok(linha, ",");
    int count = 0;

    novaLista = (listaStructCsv *)malloc(sizeof(listaStructCsv));
    if (!novaLista) {
        perror("Erro ao alocar memória");
        exit(1);
    }

    if (token != NULL) {
        novaLista->nome = strdup(token);
        count++;
    }

    while (token != NULL) {
        token = strtok(NULL, ",");
        count++;
        if (count == 2) {
            novaLista->rua = strdup(token);
        }
        if (count == 3) {
            novaLista->numero = strdup(token);
        }
    }
    novaLista->next = NULL;

    if (*inicio == NULL) {
        *inicio = novaLista;
    } else {
        while (listaPessoas->next != NULL) {
            listaPessoas = listaPessoas->next;
        }
        listaPessoas->next = novaLista;
    }
}

void criarListaPessoas(pessoas **lista, char *nome) {
    pessoas *inicio = *lista, *novaPessoa;
    novaPessoa = (pessoas *)malloc(sizeof(pessoas));
    if (!novaPessoa) {
        perror("Erro ao alocar memória");
        exit(1);
    }
    novaPessoa->nome = strdup(nome);
    novaPessoa->next = NULL;

    if (*lista == NULL) {
        *lista = novaPessoa;
    } else {
        while (inicio->next != NULL) {
            inicio = inicio->next;
        }
        inicio->next = novaPessoa;
    }
}

// void criarListaPessoas(pessoas **lista,char *nome){
//     pessoas *inicio = *lista,*list;
//     pessoas *listaDePessoas;
//     if(*lista==NULL){
//         list = (pessoas*) malloc(sizeof(pessoas));
//         strcpy(list->nome,nome);
//         list->next=NULL;
//         *lista=list;
//         // return lista;
//     }else
//     {
//         for (;inicio!=NULL; inicio=inicio->next)
//         {
//             if (inicio->next==NULL)
//             {
//                 listaDePessoas = (pessoas*) malloc(sizeof(pessoas));
//                 strcpy(listaDePessoas->nome,nome);
//                 listaDePessoas->next=NULL;
//                 if (inicio->next==NULL)
//                 {
//                     inicio->next=listaDePessoas;
//                 }
                
//                 // return listaDePessoas;
//                 /* code */
//             }
            
//             /* code */
//         }
        
//     }
    
    
    //return lista;

//}

void escreverListaPessoas(pessoas *inicio){
    pessoas *ini = inicio;
    printf("\n\tLista de pessoas\n");
    for (int i=1; ini !=NULL; ini=ini->next,i++)
    {
        printf("\n%d - %s",i,ini->nome);
    }
    
}


int main(int argc, char const *argv[])
{
    FILE *arquivo = fopen("C:\\Users\\Samsung\\Desktop\\Material\\Atividades\\C\\listaCSV\\arquivo.txt","r"); 
    char linha[100];
    listaStructCsv *lista;
    listaStructCsv *inicio=NULL;
    pessoas *inicioPessoas=NULL;
    //lista =(listaStructCsv*) malloc(sizeof(listaStructCsv));
    
    if (arquivo==NULL)
    {
        return 1;
    }
    






    while (fgets(linha,sizeof(linha),arquivo)!=NULL)
    {
        
        printf("\nLinha : %s",linha);
        tokenLinha(linha,&inicio);
        
        
        
    }
    
    for (lista = inicio; lista!=NULL; lista=lista->next)
        {
           printf("\n\tNome :%s Endereco:%s  Numero:%s\n",lista->nome,lista->rua,lista->numero);
        }
    for (listaStructCsv *ini=inicio;ini!=NULL;ini=ini->next)
    {
        if(ini->nome!=NULL){
            
                criarListaPessoas(&inicioPessoas,ini->nome);
            
        }
    }
    escreverListaPessoas(inicioPessoas);
    // Liberar a memória alocada
    while (lista != NULL) {
        listaStructCsv *temp = lista;
        lista = lista->next;
        free(temp->nome);
        free(temp->rua);
        free(temp->numero);
        free(temp);
    }

    while (inicioPessoas != NULL) {
        pessoas *temp = inicioPessoas;
        inicioPessoas = inicioPessoas->next;
        free(temp->nome);
        free(temp);
    }
    fclose(arquivo);
    return 0;
}
