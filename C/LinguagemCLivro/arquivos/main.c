#include <stdio.h>
#include <stdlib.h>
#include<string.h>
int main()
{
    printf("Hello world!\n");
    char frase[100];
    FILE *arq = fopen("cidades.txt","r");
    FILE *arq2 = fopen("cidadesdois.txt","a");
    if(arq==NULL){
        printf("Erro na abertura de arquivo\n");
        return 1;
    }
    if(arq2==NULL){
            printf("Erro na abertura de arquivo 2\n");
        return 1;
    }
    //fgets(linha, sizeof(linha), arquivo)
    //fscanf(arq,"%s",frase)
    while(fgets(frase, sizeof(frase),arq)){
        printf("%s ",frase);
        fprintf(arq2,"%s",frase);
        }
        fclose(arq);
        fclose(arq2);
    return 0;
}
