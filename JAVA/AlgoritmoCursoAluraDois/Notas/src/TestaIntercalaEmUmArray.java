public class TestaIntercalaEmUmArray {
    public static void main(String[] args) {
        Nota[] notas = {
            new Nota("andre", 7.7),
            new Nota("mariana", 5),
            new Nota("carlos", 2.5),
            new Nota("paulo", 9),
            new Nota("jonas", 3),
            new Nota("juliana", 6.7),
            new Nota("guilherme", 7),
            new Nota("lucia", 3.3),
            new Nota("ana", 2)
        };
        // Nota[] rank = intercala(notas,0,4,notas.length);
        ordena(notas,0,notas.length);
        imprime(notas);
         
    }

    private static void ordena(Nota[] notas, int inicio, int termino) 
    {
            int quantidade=termino-inicio;
            if (quantidade>1) 
            {
                int meio=(inicio+termino)/2;
                System.out.println(inicio +" "+ termino+ " "+ meio);
                ordena(notas, inicio, meio);
                ordena(notas, meio, termino);
                intercala(notas,inicio,meio,termino);
                
            }
    }

    private static Nota[] intercala(Nota[] notas,int inicio,int meio,int termino) 
    {
        Nota[] resultado = new Nota[termino-inicio];
        int atual=0;
        int atual1=inicio;
        int atual2=meio;
        while(atual1<meio && atual2<termino)
        {
            Nota nota1=notas[atual1];
            Nota nota2=notas[atual2];
            if(nota1.getNota()<nota2.getNota())
            {
                resultado[atual]=nota1;
                atual1++;
            }
            else
            {
                resultado[atual]=nota2;
                atual2++;
            }
            atual++;
        }
        while(atual1<meio)
        {
            resultado[atual]=notas[atual1];
            atual1++;
            atual++;
        }
        while(atual2<termino)
        {
            resultado[atual]=notas[atual2];
            atual2++;
            atual++;
        }
        for (int contador = 0; contador < atual; contador++) {
            notas[inicio+contador]=resultado[contador];
        }
        return notas;
    }

    private static void imprime(Nota[] rank) 
    {
        for (Nota nota : rank) {
            System.out.println(nota.getAluno()+" com nota "+ nota.getNota());
        }
    }

}
