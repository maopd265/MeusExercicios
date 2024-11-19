#include<stdio.h>
#include<stdlib.h>
#include<string.h>
typedef struct numeroInteiro{
    int num;
}numeroInteiro;

void alteraNumero(numeroInteiro *numero){
      (*numero).num=1;
}
void alteraOutroNumero(numeroInteiro *numero){
    numero->num=2;
}
int main(int argc, char const *argv[])
{
    printf("\n\tStruct parametro de funcao por ponteiro\n");
    numeroInteiro numero;
    alteraNumero(&numero);
    printf("\n\tValor: %d\n",numero.num);
    alteraOutroNumero(&numero);
    printf("\n\tValor: %d\n",numero.num);
    return 0;
}
