#include<stdio.h>
#include<stdlib.h>

typedef enum {
    HELLO,WORLD
}mensagem;


int main(int argc, char const *argv[])
{
    mensagem msg=HELLO;
    switch (msg)
    {
    case HELLO:
        printf("\nHello\n");
            break;
    
    default:
    printf("\n\t Hello World!\n");
        break;
    }
    
    return 0;
}
