#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<string.h>
int main(int argc, char const *argv[])
{
    printf("\n\t Capitulo 10\n Eh bom conversar\n\n");
    char buffer[100],buffer2[100];
    ssize_t bytesRead,bytesRead2;

    // Usando o descritor de arquivo stdin (0) para ler a entrada
    bytesRead = read(STDIN_FILENO, buffer, sizeof(buffer) - 1);
    // bytesRead2 = read(STDOUT_FILENO, buffer2, sizeof(buffer2) - 1);
    if (bytesRead == -1) {
        perror("Erro ao ler a entrada");
        exit(EXIT_FAILURE);
    }
    // if (bytesRead2 == -1) {
    //     perror("Erro ao ler a saida");
    //     exit(EXIT_FAILURE);
    // }

    // Certificar-se de que a string está terminada em NULL
    buffer[bytesRead] = '\0';
    // buffer2[bytesRead2]= '\0';

    printf("Entrada lida: %s", buffer);
    // printf("Saida lida : %s ",buffer2);

    return 0;
}
