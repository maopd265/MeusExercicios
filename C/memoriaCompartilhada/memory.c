#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main() {
    int fd[2]; // Descritores de arquivo para o pipe
    int valor;

    if (pipe(fd) == -1) {
        perror("pipe");
        exit(EXIT_FAILURE);
    }

    // Ler o valor do pipe
    if (read(fd[0], &valor, sizeof(int)) == -1) {
        perror("read");
        exit(EXIT_FAILURE);
    }

    // Exibir o valor lido
    printf("Valor lido do pipe: %d\n", valor);

    return 0;
}