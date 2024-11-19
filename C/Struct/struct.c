#include<stdio.h>
#include<stdlib.h>
#include<string.h>
typedef struct Pessoa{
     char *nome;
    int idade;
     char *endereco;
}Pessoa;
Pessoa atribuicao(Pessoa pessoa);
Pessoa leitura(Pessoa pessoa);

Pessoa leitura(Pessoa pessoa){
     printf("Digite o seu nome:");
    scanf("%s",pessoa.nome);
    printf("\n Digite seu endereco:");
    scanf("%s",pessoa.endereco);
    printf("\nDigite sua idade:");
    scanf("%d",&pessoa.idade);
    return pessoa;
}
Pessoa atribuicao(Pessoa pessoa){
    pessoa.nome = malloc(strlen("Mauricio") + 1);
    strcpy(pessoa.nome, "Mauricio");

    pessoa.endereco = malloc(strlen("Rua DR Jose montaury") + 1);
    strcpy(pessoa.endereco, "Rua DR Jose montaury");

    pessoa.idade = 27;
    return pessoa;
}
int main(int argc, char const *argv[])
{
    Pessoa pessoa ;//={"Mauricio",27,"Rua DR Jose montaury"} ;
    pessoa.nome =(char *) malloc(100 * sizeof(char));
     pessoa.endereco =(char *) malloc(100 * sizeof(char));
    pessoa.idade= NULL;
   // pessoa = atribuicao(pessoa);
    pessoa = leitura(pessoa);
    printf("\n\t Nome: %s \n",pessoa.nome);
    printf("\n\tIdade : %d\n",pessoa.idade);
    printf("\n\tEndereco: %s\n",pessoa.endereco);
    free(pessoa.endereco);
    free(pessoa.nome);
    return 0;
}
