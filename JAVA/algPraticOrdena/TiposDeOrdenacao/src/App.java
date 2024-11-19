public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        int [] vetor={1,2,57,8,5,2,123,3567,4,3,3,9,10,6,7,8,9};
        // selectionSort(vetor,vetor.length);
        // bubbleSort(vetor,vetor.length);
        insertionSort(vetor,vetor.length);
        imprime(vetor);

    }

    private static void insertionSort(int[] vetor, int tamanhoVetor) 
    {
        for (int atual = 0; atual < tamanhoVetor; atual++) {
            int analise=atual ;
            while(analise>0 && vetor[analise]<vetor[analise-1])
            {
                troca(vetor, analise, analise-1);
                analise--;
            }
        }
    }

    private static void bubbleSort(int[] vetor, int tamanhoVetor) 
    {
        for (int i = 0; i < tamanhoVetor-1; i++) 
        {
            for (int j = 0; j < tamanhoVetor-1; j++) 
            {
                if(vetor[j]>vetor[j+1])
                {
                    troca(vetor, j+1, j);
                }
                
            }
            
        }
    }

    private static void selectionSort(int[] vetor, int tamanhoDoVetor) 
    {
        for (int atual = 0; atual < tamanhoDoVetor; atual++) {
            int menor = buscaMenor(vetor,atual,tamanhoDoVetor);
            troca(vetor,menor,atual);
        }
    }

    private static void troca(int[] vetor, int menor, int atual) 
    {
        int aux = vetor[atual];
        vetor[atual]=vetor[menor];
        vetor[menor]=aux;
    }

    private static int buscaMenor(int[] vetor, int atual, int tamanhoDoVetor) {
        int menor = atual;
        for (int i = atual; i < tamanhoDoVetor; i++) {
            if(vetor[i]<vetor[menor])
            {
                menor=i;
            }
        }
        return menor;
    }

    private static void imprime(int[] vetor) 
    {
        int j=0;
        for (int i : vetor) {
            System.out.println("pos "+j+":"+i);
            j++;
        }
    }

    

     
    }

