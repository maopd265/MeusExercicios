#include<stdio.h>
#include<stdlib.h>
#include<string.h>



int main(int argc, char const *argv[])
{
    char *palavra="Linguagem c";
    char *palavra1=strdup(palavra);
    printf("%s",palavra1);
    free(palavra1);
    /* code */
    return 0;
}
