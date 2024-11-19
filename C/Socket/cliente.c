// cliente.c
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <arpa/inet.h>

#define PORT 8080
#define BUFFER_SIZE 1024

int main() {
    int sock = 0;
    struct sockaddr_in serv_addr;
    char *message = "Olá do cliente";
    char buffer[BUFFER_SIZE] = {0};

    // Criando o socket
    if ((sock = socket(AF_INET, SOCK_STREAM, 0)) < 0) {
        perror("Erro ao criar socket");
        exit(EXIT_FAILURE);
    }

    serv_addr.sin_family = AF_INET;
    serv_addr.sin_port = htons(PORT);

    // Convertendo endereço IP para binário
    if (inet_pton(AF_INET, "127.0.0.1", &serv_addr.sin_addr) <= 0) {
        perror("Endereço inválido ou não suportado");
        close(sock);
        exit(EXIT_FAILURE);
    }

    // Conectando ao servidor
    if (connect(sock, (struct sockaddr *)&serv_addr, sizeof(serv_addr)) < 0) {
        perror("Falha na conexão");
        close(sock);
        exit(EXIT_FAILURE);
    }

    // Enviando mensagem ao servidor
    send(sock, message, strlen(message), 0);
    printf("Mensagem enviada\n");

    // Lendo resposta do servidor
    read(sock, buffer, BUFFER_SIZE);
    printf("Resposta do servidor: %s\n", buffer);

    // Fechando o socket
    close(sock);

    return 0;
}