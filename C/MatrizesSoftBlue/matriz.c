#include<stdio.h>
#include<stdlib.h>
#include<string.h>
int main(int argc, char const *argv[])
{
    int *matriz=NULL;
    matriz = (int *)malloc(5*sizeof(int));
    matriz[0] = 1;
    matriz[1]= 1;
    matriz[2] = 1;
    matriz[3] = 1;
    matriz[4] = 1;
    ///matriz={1,2,3,4,5};  ///--- não pode ser utilizado pois a alocação dinamica. A sintaxe {1,2,3,4,5} é utilizada em matriz estática
    return 0;
}
