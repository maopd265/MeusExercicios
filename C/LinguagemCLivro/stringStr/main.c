#include <stdio.h>
#include <stdlib.h>
#include<string.h>
int main()
{
    printf("Hello world!\n");
    char *palavra = "Sistema operacional Linux!";
    char *splitToken = "Linux";
    char *splitOutroToken = "operacional";

    char *subString=strstr(palavra,splitToken);
    printf("\n\t 1- Encontrou a palavra :%s\n",subString);

   char *subStringDois=strstr(palavra,splitOutroToken);
    printf("\n\t 2- Encontrou a palavra :%s\n",subStringDois);
    printf("\n\t Frase : %s \n",palavra);
    return 0;
}
