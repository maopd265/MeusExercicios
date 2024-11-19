// servidor.c
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <arpa/inet.h>

#define PORT 8080
#define BUFFER_SIZE 1024

int main() {
    int server_fd, new_socket;
    struct sockaddr_in address;
    int opt = 1;
    int addrlen = sizeof(address);
    char buffer[BUFFER_SIZE] = {0};
    char *response = "Mensagem recebida";

    // Criando o socket
    if ((server_fd = socket(AF_INET, SOCK_STREAM, 0)) == 0) {
        perror("Falha ao criar socket");
        exit(EXIT_FAILURE);
    }

    // Anexando o socket à porta 8080
    if (setsockopt(server_fd, SOL_SOCKET, SO_REUSEADDR | SO_REUSEADDR, &opt, sizeof(opt))) {
        perror("Falha em setsockopt");
        close(server_fd);
        exit(EXIT_FAILURE);
    }
    address.sin_family = AF_INET;
    address.sin_addr.s_addr = INADDR_ANY;
    address.sin_port = htons(PORT);

    // Ligando o socket ao endereço e porta especificados
    if (bind(server_fd, (struct sockaddr *)&address, sizeof(address)) < 0) {
        perror("Falha em bind");
        close(server_fd);
        exit(EXIT_FAILURE);
    }

    // Escutando por conexões
    if (listen(server_fd, 3) < 0) {
        perror("Falha em listen");
        close(server_fd);
        exit(EXIT_FAILURE);
    }

    printf("Esperando por conexões...\n");

    // Aceitando uma conexão
    if ((new_socket = accept(server_fd, (struct sockaddr *)&address, (socklen_t*)&addrlen)) < 0) {
        perror("Falha em accept");
        close(server_fd);
        exit(EXIT_FAILURE);
    }

    // Lendo mensagem do cliente
    read(new_socket, buffer, BUFFER_SIZE);
    printf("Mensagem recebida: %s\n", buffer);

    // Enviando resposta ao cliente
    send(new_socket, response, strlen(response), 0);
    printf("Resposta enviada\n");

    // Fechando o socket
    close(new_socket);
    close(server_fd);

    return 0;
}