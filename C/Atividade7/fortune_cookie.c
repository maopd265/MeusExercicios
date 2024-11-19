#include<stdio.h>
#include<string.h>
void fortuneCookie(char msg[])
{
    printf("Message reads: %s\n",msg);
    printf("Total de bytes ocupados: %i bytes\n",sizeof(msg));
    int i = strlen(msg);
    printf("%d\n",i);
}

int main()
{
    char mensagem[] = "Cookies make you fat";
    fortuneCookie(mensagem);
    // scanf("%s",mensagem);
    // fortuneCookie(mensagem);
    int i = strlen(mensagem);
    printf("%d\n",i);
    /* code */
    return 0;
}
