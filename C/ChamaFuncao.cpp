#include<stdio.h>

void chamaFuncao(int i)
{
	if(i==1){
	
	printf("Chama funcao 1");
	}else{
	chamaFuncao(i+1);
	printf("Chama funcao %d",i);
	return;
	}
	
}

int main(){
	int i=1;
	chamaFuncao(i);
}
