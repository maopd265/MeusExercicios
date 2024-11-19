#include<stdio.h>
#include<stdlib.h>
int main(int argc, char const *argv[])
{
    int *array[2];
    int numero=1,a=2;
    
    array[0] = &numero;
    array[1]=&a;
    for (int i = 0; i < 2; i++)
    {
         printf("\n\t Endereco: %d  \n",array[i]);
         printf("\n\t Valor: %d \n",*array[i]);
    }
    
   
    return 0;
}
