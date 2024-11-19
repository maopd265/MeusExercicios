#include<stdio.h>
#include<math.h>
#include<stdlib.h>
int iteracao =1000;
float erro =1e-10;
int iter;
	float *x;
float normaVetor(float * x,int n)
{
	float soma=0;
	for(int i=0;i<n;i++)
	{
		soma+=pow(x[i],2);
	}
	return sqrt(soma);

}
float ** alocarMemoriaMatriz(int linhas,int colunas)
{
	float ** matriz = (float **)malloc(sizeof(float*) *linhas);
	for(int i=0;i<linhas;i++)
	{
		matriz[i]=(float*)malloc(sizeof(float)*(colunas));
		
	}
	return matriz;
}
//float * alocarMemoriaVetor(int num)
//{
//		float * vetor=malloc((num)*sizeof(float));
//		 
//		return vetor;
//}
void desalocarMemoriaVetor(float *vetor,int linhas)
{
 
	free(vetor);
}
void desalocarMemoriaMatriz(float **vetor,int linhas)
{
	for(int i=0;i<linhas;i++)
	{
		free(vetor[i]);
	}
	free(vetor);
}
void jacobi(float ** A,float b,int n){

	float *  z,*novo_x;
	float soma;
	iter = 0;
	for(int i=0;i<n;i++)
	{
		z[i]=0;
		novo_x[i]=0;
	}
  
	while (iter < iteracao){
    
		for (int i=0;i<n;i++){
			soma = 0;
			for (int j=0;j<n;j++){
				if (i != j){
					soma +=  A[i][j] * z[j];
				}
			novo_x[i] = (b[i] - soma)/A[i][i];
      		}
		if (abs( norma_vetor(z,n) - norma_vetor(novo_x,n)) < erro){
			 for(int i=0;i<sizeof(z)/sizeof(z[0]);i++)
			{
				x[i]=novo_x[i];
			}
			return; //////////matriz
		
		}else{
		for(int i=0;i<n;i++)
		{
			z[i]=novo_x[i];
		}
   		}
		iter ++;
    	}
    }
    for(int i=0;i<sizeof(z)/sizeof(z[0]);i++)
	{
		x[i]=z[i];
	}
	return; //////////matriz
}
float ** inicializarMatrizA(float ** A)
{
				 A[0][0]=10;
				 A[0][1]=-1;
				 A[0][2]=2;
				 A[0][3]=0;
				 
				 A[1][0]=-1;
				 A[1][1]=11;
				 A[1][2]=-1;
				 A[1][3]=3;
				 
				 A[2][0]=2;
				 A[2][1]=-1;
				 A[2][2]=10;
				 A[2][3]=-1;
				 
				 A[3][0]=0;
				 A[3][1]=3;
				 A[3][2]=-1;
				 A[3][3]=8;
				 
        	      return A;
}
void escreverVetor(float b[])
{
	for(int i=0;i<4;i++)
	{
	printf(" %f ",b[i]);
	}
}
int main()
{
	int n=4;

	
	float multi=0;
	float **	A ;
	A=alocarMemoriaMatriz(n,n);
	A=inicializarMatrizA(A);
//	x=alocarMemoriaVetor(n);
        	      
            float	b[4] = {6, 25, -11, 15};
           // float	n = A.shape[0]
 
	for(int i=0;i<4;i++)
	{
		for(int j=0;j<4;j++)
		{
			printf(" %f ",A[i][j]);
		}
		printf("\n");
	}
	escreverVetor(b);
	printf("%d",n);

	  jacobi(A,b,n);


	printf("Numero de iteracoes: %d",iter);
	printf("Resultado: ");
		for(int i=0;i<4;i++)
	{
			printf(" %f ",x[i]);
	}
	//printf(x);

	printf("Teste: ");
	//printf(np.dot(A,x));
	for(int i=0;i<4;i++)
	{
		
			multi=multi+(A[i][i]*x[i]);
		
	}
	printf(" %f ",multi);
	 desalocarMemoriaMatriz(A,n);
	return 0;
}

