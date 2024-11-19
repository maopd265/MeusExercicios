#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct listaStructCsv {
    char *nome;
    char *rua;
    char *numero;
    struct listaStructCsv *next;
} listaStructCsv;

typedef struct pessoas {
    char *nome;
    struct pessoas *next;
} pessoas;

void tokenLinha(char *linha, listaStructCsv **inicio) {
    listaStructCsv *listaPessoas = *inicio, *novaLista;
    char *token = strtok(linha, ",");
    int count = 0;

    novaLista = (listaStructCsv *)malloc(sizeof(listaStructCsv));
    if (!novaLista) {
        perror("Erro ao alocar memória");
        exit(1);
    }

    if (token != NULL) {
        novaLista->nome = strdup(token);
        count++;
    }

    while (token != NULL) {
        token = strtok(NULL, ",");
        count++;
        if (count == 2) {
            novaLista->rua = strdup(token);
        }
        if (count == 3) {
            novaLista->numero = strdup(token);
        }
    }
    novaLista->next = NULL;

    if (*inicio == NULL) {
        *inicio = novaLista;
    } else {
        while (listaPessoas->next != NULL) {
            listaPessoas = listaPessoas->next;
        }
        listaPessoas->next = novaLista;
    }
}

void criarListaPessoas(pessoas **lista, char *nome) {
    pessoas *inicio = *lista, *novaPessoa;
    novaPessoa = (pessoas *)malloc(sizeof(pessoas));
    if (!novaPessoa) {
        perror("Erro ao alocar memória");
        exit(1);
    }
    novaPessoa->nome = strdup(nome);
    novaPessoa->next = NULL;

    if (*lista == NULL) {
        *lista = novaPessoa;
    } else {
        while (inicio->next != NULL) {
            inicio = inicio->next;
        }
        inicio->next = novaPessoa;
    }
}

void escreverListaPessoas(pessoas *inicio) {
    pessoas *ini = inicio;
    int i = 1;
    printf("\n\tLista de pessoas\n");
    while (ini != NULL) {
        printf("\n%d - %s", i, ini->nome);
        ini = ini->next;
        i++;
    }
}

int main(int argc, char const *argv[]) {
    FILE *arquivo = fopen("C:\\Users\\Samsung\\Desktop\\Material\\Atividades\\C\\listaCSV\\arquivo.txt", "r");
    char linha[100];
    listaStructCsv *lista = NULL;
    pessoas *inicioPessoas = NULL;

    if (arquivo == NULL) {
        perror("Erro ao abrir o arquivo");
        return 1;
    }

    while (fgets(linha, sizeof(linha), arquivo) != NULL) {
        printf("\nLinha: %s", linha);
        tokenLinha(linha, &lista);
    }

    listaStructCsv *tempLista = lista;
    while (tempLista != NULL) {
        printf("\n\tNome: %s Endereco: %s Numero: %s\n", tempLista->nome, tempLista->rua, tempLista->numero);
        criarListaPessoas(&inicioPessoas, tempLista->nome);
        tempLista = tempLista->next;
    }

    escreverListaPessoas(inicioPessoas);

    // Liberar a memória alocada
    while (lista != NULL) {
        listaStructCsv *temp = lista;
        lista = lista->next;
        free(temp->nome);
        free(temp->rua);
        free(temp->numero);
        free(temp);
    }

    while (inicioPessoas != NULL) {
        pessoas *temp = inicioPessoas;
        inicioPessoas = inicioPessoas->next;
        free(temp->nome);
        free(temp);
    }

    fclose(arquivo);
    return 0;
}