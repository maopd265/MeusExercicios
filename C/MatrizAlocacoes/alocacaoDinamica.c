#include<stdio.h>
#include<stdlib.h>

int main(int argc, char const *argv[])
{
    int **matriz;
    int count=0;
    matriz = (int **) malloc (2*sizeof(int *));
    matriz[0]=(int *)malloc (3*sizeof(int));
    matriz[1]=(int *)malloc (3*sizeof(int));
    for (int i = 0; i < 2; i++)
    {
        for (int j = 0; j < 3; j++)
        {
            matriz[i][j]=count;
            count++;
            printf("%d ",matriz[i][j]);
        }
        printf("\n");
        
    }
    for (int i = 0; i < 3; i++)
    {
        free(matriz[i]);
    }
    free(matriz);
    
    return 0;
}
