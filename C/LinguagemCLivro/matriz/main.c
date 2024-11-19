#include <stdio.h>
#include <stdlib.h>
void alterarDiagonalPrincipal(int *matriz,int linha,int coluna){
 for(int i =0 ;i<linha;i++){
        for(int j=0;j<coluna;j++){
            if(i==j){
                *(matriz+i*coluna+j)=0;
            }
            printf("\t %d ",*(matriz+i*coluna+j));
        }
        printf("\n");
    }


}
void alterarColuna(int *matriz, int linha, int coluna){
    for(int i=0;i<linha;i++){
        for(int j=0;j<coluna;j++){
            if(j==2){
                *(matriz+i*coluna+j)=0;
            }
        }
    }



}
void alterarPrimeiraLinha(int *matriz,int linha, int coluna){
    for(int i=0;i<linha;i++){
        for(int j=0;j<coluna;j++){
            if(i==0){
                *(matriz+i*coluna+j)=0;
            }
        }
    }
}
void alterarDiagonalSec(int *matriz,int tamanho){
    for (int i = 0,j=tamanho-1; i < tamanho,j>=0; i++,j--) {
        //matriz[i][tamanho - 1 - i] = 1; // Preenche a diagonal secundária com o valor 1
        *(matriz+i*tamanho+j)=0;
    }


}
void escreverMatriz(int matriz[3][3]){
for(int i =0 ;i<3;i++){
        for(int j=0;j<3;j++){
            printf("\t %d ",matriz[i][j]);
        }
        printf("\n");
    }
}
void restaurarMatriz(int *matriz,int linha,int coluna){
    int count = 1;
        for(int i=0;i<linha;i++){
           for(int j=0;j<coluna;j++){
            *(matriz+i*coluna+j)=count;
            count++;
           }
        }
}
int main()
{
    int matriz[3][3]={{1,2,3},
                     {4,5,6},
                     {7,8,9}};
    int i=3,j=3;
    system("color a");
    printf("Hello world!\n");
    printf("\tMATRIZ ORIGINAL\n");
    escreverMatriz(matriz);


    printf("\tMATRIZ COM ALTERACAO NA DIAGONAL PRINCIPAL\n");
    alterarDiagonalPrincipal(matriz,i,j);


    printf("\n\tMATRIZ COM ALTERACAO NA PRIMEIRA LINHA \n");
    restaurarMatriz(matriz,i,j);
    alterarPrimeiraLinha(matriz,i,j);
    escreverMatriz(matriz);



    printf("\n\tMATRIZ COM ALTERACAO NA TERCEIRA COLUNA \n");
    restaurarMatriz(matriz,i,j);
    alterarColuna(matriz,i,j);
    escreverMatriz(matriz);


    printf("\n\tMATRIZ COM ALTERACAO NA DIAGONAL SECUNDARIA \n");
    restaurarMatriz(matriz,i,j);
    alterarDiagonalSec(matriz,i);
    escreverMatriz(matriz);

    return 0;
}
