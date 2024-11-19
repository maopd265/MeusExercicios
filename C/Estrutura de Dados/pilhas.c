#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include<string.h>
// Define o tamanho máximo da pilha
#define MAX 100

//Estrutura da lista simples
typedef struct Lista{
    int valor;
   struct Lista *next;
}Lista;
// Estrutura da pilha
typedef struct {
    int elementos[MAX];
    int topo;
} Pilha;

// Função para inicializar a pilha
void inicializar(Pilha *p) {
    p->topo = -1; // -1 indica que a pilha está vazia
}

// Verifica se a pilha está vazia
bool isEmpty(Pilha *p) {
    return p->topo == -1;
}

// Verifica se a pilha está cheia
bool isFull(Pilha *p) {
    return p->topo == MAX - 1;
}

// Insere um elemento na pilha
bool push(Pilha *p, int valor) {
    if (isFull(p)) {
        printf("Erro: Pilha cheia.\n");
        return false;
    }
    p->elementos[++(p->topo)] = valor;
    return true;
}

// Remove um elemento da pilha
int pop(Pilha *p) {
    if (isEmpty(p)) {
        printf("Erro: Pilha vazia.\n");
        return -1; // Valor de erro
    }
    return p->elementos[(p->topo)--];
}

// Consulta o elemento no topo sem remover
int peek(Pilha *p) {
    if (isEmpty(p)) {
        printf("Erro: Pilha vazia.\n");
        return -1; // Valor de erro
    }
    return p->elementos[p->topo];
}



void inserirPilhasNaLista(Pilha *p,Pilha *aux){
        Lista * nodo1 = (Lista*)malloc(sizeof(Lista));
        Lista * nodo2 = (Lista*)malloc(sizeof(Lista));
        Lista * nodo3 = (Lista*)malloc(sizeof(Lista));
        Lista * nodo4 = (Lista*)malloc(sizeof(Lista));
        Lista * nodo5 = (Lista*)malloc(sizeof(Lista));
        Lista * nodo6 = (Lista*)malloc(sizeof(Lista));
        Lista * nodo7 = (Lista*)malloc(sizeof(Lista));
    if (nodo1 == NULL || nodo2 == NULL || nodo3 == NULL || nodo4 == NULL || 
    nodo5 == NULL || nodo6 == NULL || nodo7 == NULL) {
    printf("\nERROR: Falha ao alocar memória para os nós!\n");
    return;
}

    if (!isEmpty(p))
    {
        nodo1->valor=peek(p);
        nodo1->next=nodo2;
        pop(p);
    }
    
    if (!isEmpty(p))
    {
       nodo2->valor=peek(p);
        nodo2->next=nodo3;
        pop(p);
    }
    if(!isEmpty(p)){
    nodo3->valor=peek(p);
    nodo3->next=nodo4;
    }
    if(!isEmpty(aux)){
    nodo4->valor=peek(aux);
    nodo4->next=nodo5;
    pop(aux);
    }
    if(!isEmpty(aux)){
    nodo5->valor=peek(aux);
    nodo5->next=nodo6;
    pop(aux);
    }
    if(!isEmpty(aux)){
    nodo6->valor=peek(aux);
    pop(aux);
    
    }
    nodo6->next=nodo7;
    nodo7->next=NULL;
    for (Lista *i=nodo1;i!=NULL; i=i->next)
    {
        printf("%d\n",i->valor);
    }
    
    
}
int main() {
    Pilha p,aux,paux;
    Lista *lista =NULL;
    inicializar(&p);
    inicializar(&aux);
    inicializar(&paux);
    push(&p, 10);
    
    push(&p, 20);
    
    push(&p, 30);
   
    
    push(&paux, 10);
    printf("Elemento no topo agora paux: %d\n", peek(&paux));
    push(&paux, 20);
    printf("Elemento no topo agora paux: %d\n", peek(&paux));
    push(&paux, 30);
    printf("Elemento no topo agora paux: %d\n", peek(&paux));
    

    printf("Elemento no topo: %d\n", peek(&p)); // 30

    printf("Removendo: %d\n", pop(&p)); // 30

    printf("Elemento no topo agora: %d\n", peek(&p)); // 20
    push(&p,30);
   
        /*P=10 20 30*/
        /*AUX=30 20 10*/
    push(&aux,peek(&paux));
    printf("Elemento no topo agora AUX: %d\n", peek(&aux));
   
    pop(&paux);
    push(&aux,peek(&paux));
    printf("Elemento no topo agora AUX: %d\n", peek(&aux));
   
    pop(&paux);
    push(&aux,peek(&paux));
    printf("Elemento no topo agora AUX: %d\n", peek(&aux));
   


    /*10 20 30 30 20 10*/
        
        
    
    inserirPilhasNaLista(&p,&aux);





    return 0;
}