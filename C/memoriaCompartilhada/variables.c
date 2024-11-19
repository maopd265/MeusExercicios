#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main() {
    int fd[2]; // Descritores de arquivo para o pipe
    int valor = 42;

    if (pipe(fd) == -1) {
        perror("pipe");
        exit(EXIT_FAILURE);
    }

    // Escrever o valor no pipe
    if (write(fd[1], &valor, sizeof(int)) == -1) {
        perror("write");
        exit(EXIT_FAILURE);
    }

    // Fechar o descritor de leitura do pipe
    close(fd[0]);

    return 0;
}