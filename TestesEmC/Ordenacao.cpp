#include<stdio.h>
#include<stdlib.h>
int buscaMenor(int vetor[],int inicio,int termino)
{
	int menor=inicio;
	for(int i=inicio;i<termino;i++)
	{
		if(vetor[i]<vetor[menor])
		{
			menor=i;
		}
	}
	return menor;
}
void troca(int vetor[],int atual,int menor)
{
	int aux = vetor[atual];
	vetor[atual]=vetor[menor];
	vetor[menor]=aux;
}
void selectionSort(int vetor[],int termino)
{
	for(int atual=0;atual<termino;atual++)
	{
		int menor=buscaMenor(vetor,atual,termino);
		troca(vetor,menor,atual);	
	}
	
}


void imprimeVetor(int vet[],int totalPos)
{
	for(int i=0;i<totalPos;i++)
	{
		printf("%d\n",vet[i]);
	}
}
void bubbleSort(int vetor[],int termino)
{
	for(int i=0;i<termino;i++)
	{
		for(int j=0;j<termino;j++)
		{
			if(vetor[j]>vetor[j+1])
			{
				troca(vetor,j,j+1);
			}
		}
	}
}
void insertionSort(int vetor[],int termino)
{
	for(int i=0;i<termino;i++)
	{
		int analise = i;
		while(analise>0 && vetor[analise]<vetor[analise-1])
		{
			troca(vetor,analise,analise-1);
			analise--;
		}
	}
}
int main()
{
	int vet[8]={2,3,4,2,1,6,5,8};
	int totalPos =sizeof(vet)/sizeof(vet[0]);
	imprimeVetor(vet,totalPos);
	//printf("%d",sizeof(vet)/sizeof(vet[0]));
	int menor= buscaMenor(vet,0,sizeof(vet)/sizeof(vet[0]));
	printf("\nO menor esta na pos %d =%d",menor,vet[menor]);
	printf("\n-----------------------------------------------------\n");
//	selectionSort(vet,totalPos);
//insertionSort(vet,totalPos);
//	bubbleSort(vet,totalPos);
	imprimeVetor(vet,totalPos);
}
