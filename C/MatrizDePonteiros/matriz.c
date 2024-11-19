#include<stdio.h>
#include<stdlib.h>
#include<math.h>
#include<string.h>


int main(int argc, char const *argv[])
{
    int a=1,b=2,c=3;
    int *matrizPointer;
    int *matriz[3]={a,b,c};
    int *matriz2[3];
    matriz2[0]=&a;
    matriz2[1]=&b;
    matriz2[2]=&c;
    for (int i = 0; i < sizeof(matriz)/sizeof(int); i++)
    {
        printf("\n%d:%d\n",i,matriz[i]);
    }
    printf("\n");
    for (int i = 0; i < sizeof(matriz)/sizeof(int); i++)
    {
        printf("\n%d:%d\n",i,matriz2[i]);
    }
    matrizPointer=(int *)malloc(2*sizeof(int));
    matrizPointer[0]=1;
    matrizPointer[1]=123;
    printf("\n\t[0]:%d\n\t[1]:%d",matrizPointer[0],matrizPointer[1]);
    free(matrizPointer);
    return 0;
}
