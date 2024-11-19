#include<stdio.h>

int compararNumero(int a ,int b){
    return (a>b)?a:b;
}


int main(int argc, char const *argv[])
{
    printf("\nNumero:%d\n",compararNumero(2054,1360));
    return 0;
}
