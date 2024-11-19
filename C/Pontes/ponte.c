#include<stdio.h>
#include<stdlib.h>
#include<string.h>
typedef struct{
      char *nome;
      char *continente;
      struct island *next;
    }island;
island* create(char *nome,char *continente){
    island *i = malloc(sizeof(island));
    i->nome=nome;
    i->continente=continente;
    i->next=NULL;
    return i;
}
void display(struct island *start){
    island *i=start;
    for(;i!=NULL;i=i->next){
        printf("\n\tNome : %s Continente: %s \n",i->nome,i->continente);

    }
}



int main(int argc, char const *argv[])
{
    
    

    
    island ilha1= {"Ilha dos coqueiros","Oceania",NULL};
    island ilha2= {"Ilha dos Ioxi","Africa",NULL};
    island ilha3= {"Ilha do Sol","America do sul",NULL};
    
    // ilha1 =(island*) malloc(1*sizeof(island));
    ilha1.next = &ilha2;
    ilha2.next= &ilha3;
    display(&ilha1);
    return 0;
}
