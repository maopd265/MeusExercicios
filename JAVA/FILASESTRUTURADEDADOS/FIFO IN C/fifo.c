#include<stdio.h>
#include<stdlib.h>
/*Exercício - Siga a execução de uma inserção e uma retirada na fila representada pela fig 6.8, desenhando os diagramas intermediários após a execução de cada comando. */
typedef struct Node{
 
         int data;
         struct Node* next;

}Node;

typedef struct Queue{
    Node* front;
    Node* rear;
}Queue;

Queue* createFifo(){
    Queue *fifo= (Queue*)malloc(sizeof(Queue));
    fifo->front=fifo->rear=NULL;
    return fifo;

}

void initializeQueue(int value,Queue *fifo){
    Node* nodo = (Node*)malloc(sizeof(Node));
    nodo->data=value;
    nodo->next=NULL;
    if (fifo->front==NULL)
    {
        fifo->front=nodo;
        fifo->rear=fifo->front;
        return;
        /* code */
    }
    fifo->rear->next=nodo;
    fifo->rear=nodo;    
    
    

}
void escreverFila(Queue *fila){
    Node *nodo =fila->front;
    while(nodo){
        printf(" %d ",nodo->data);
        nodo=nodo->next;
    }
    printf("\n");
}
void removerElementoDaFila(Queue *fila){
   if(fila==NULL){
    return;
   }
    Node* nodo = fila->front;
    fila->front=nodo->next;
}
int main(int argc, char const *argv[])
{
    Queue *fila = createFifo();
    //próximo passo precisamos inserir valores na fila
    initializeQueue(10,fila);
    initializeQueue(100,fila);
    initializeQueue(210,fila);
    initializeQueue(30,fila);
    initializeQueue(40,fila);
    removerElementoDaFila(fila);
    escreverFila(fila);
    return 0;
}
