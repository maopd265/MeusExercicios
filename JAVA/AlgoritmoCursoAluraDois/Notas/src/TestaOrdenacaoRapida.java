import java.util.Scanner;

public class TestaOrdenacaoRapida {
    public static void main(String[] args) {
        Nota[] notas = {
            new Nota("andre", 4),
            new Nota("carlos", 8.5),
            new Nota("ana", 10),
            new Nota("jonas", 3),
            new Nota("juliana", 6.7),
            new Nota("lucia", 9.3),
            new Nota("paulo", 9),
            new Nota("mariana", 5),
            new Nota("guilherme", 7)
        };
         ordena(notas,0,notas.length);
        imprime(notas);
        int num = busca(notas,0,notas.length,6.7);
        System.out.println("pos:"+num);
        imprime(notas);
        Scanner scan =new Scanner(System.in);
    }

    private static int busca(Nota[] notas, int de, int ate, double buscando) {
       int meio = (de+ate)/2;
       Nota nota = notas[meio];
       if(buscando==nota.getNota())
       {
           return meio;
       }
       if (buscando<nota.getNota()) 
       {
        return busca(notas,de,meio-1,buscando);   
       }
        return busca(notas,meio+1,ate,buscando); 
    }

    private static void ordena(Nota[] notas, int de, int ate) 
    {
        int elementos = ate-de;
        if (elementos>1) 
        {
            int posicaoPivo=particiona(notas,de,ate);
            ordena(notas, de, posicaoPivo);
            ordena(notas, posicaoPivo+1, ate);
        }
        
    }

    private static int particiona(Nota[] notas, int inicial, int termino) {
        int menoresEncontrados= 0;
        Nota pivo=notas[termino-1];
        
         
        for (int analisando = 0; analisando < termino-1; analisando++) {
            Nota atual=notas[analisando];
            if (atual.getNota()<=pivo.getNota()) {
                troca(notas, analisando, menoresEncontrados);
                menoresEncontrados++;
                
            }
        }
        troca(notas,termino-1,menoresEncontrados);
        return menoresEncontrados;
    }
    private static void troca(Nota[] notas, int de, int para)
    {
        Nota nota1=notas[de];
        Nota nota2=notas[para];
        notas[de]=nota2;
        notas[para]=nota1;
    }
    private static void imprime(Nota[] notas)
     {
        for (int atual = 0; atual < notas.length; atual++) {
            Nota nota=notas[atual];
            System.out.println(nota.getAluno()+" "+nota.getNota());
        }
    }
    }

