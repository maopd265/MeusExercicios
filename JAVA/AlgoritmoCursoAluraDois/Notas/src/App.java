public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Nota[] notasDoMauricio = {
            new Nota("andre", 4),
            new Nota("mariana", 5),
            new Nota("carlos", 8.5),
            new Nota("paulo", 9)
        };
        Nota[] notasDoAlberto = { 
            new Nota("jonas", 3),
            new Nota("juliana", 6.7),
            new Nota("guilherme", 7),
            new Nota("lucia", 9.3),
            new Nota("ana", 10)
    
        };
        Nota[] rank= junta(notasDoMauricio,notasDoAlberto);
        imprime(rank);
        
    
    }
    private static void imprime(Nota[] rank) 
    {
        for (Nota nota : rank) 
        {
           System.out.println(nota.getAluno()+" "+ nota.getNota()); 
        }
    }
    private static Nota[] junta(Nota[] notasDoMauricio, Nota[] notasDoAlberto) {
        int total= notasDoMauricio.length+notasDoAlberto.length;
        Nota[] resultado = new Nota[total];
        int atualMauricio= 0;
        int atualAlberto=0;
        int atual= 0;
        
        while(atualMauricio<notasDoMauricio.length && atualAlberto<notasDoAlberto.length)
        {
            Nota nota1=notasDoMauricio[atualMauricio];
            Nota nota2=notasDoAlberto[atualAlberto];
            if (nota1.getNota()<nota2.getNota()) {
                resultado[atual]=nota1;
                atualMauricio++;
            } else {
                resultado[atual]=nota2;
                atualAlberto++;
            }
            atual++;
        }
        // while(atualMauricio<atualMauricio.length)
        // {
        //     resultado[atual]=notas[atual1];
        //     atual1++;
        //     atual++;
        // }
        // while(atualAlberto<termino)
        // {
        //     resultado[atual]=notas[atual2];
        //     atual2++;
        //     atual++;
        // }
        return resultado;
    
    }

}
