public class TestaPivota {
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

        quebraPivo(notas,0,notas.length);
            for (int atual = 0; atual < notas.length; atual++) {
                Nota nota=notas[atual];
                System.out.println(nota.getAluno()+" "+nota.getNota());
            }
    }

    private static void quebraPivo(Nota[] notas,int inicial,int termino) 
    {
        Nota pivo = notas[termino-1];
        int menoresEncontrados=0;
        for (int analisando = 0; analisando < termino; analisando++) {
            Nota atual=notas[analisando];
            if (atual.getNota()<=pivo.getNota()) {
                
                menoresEncontrados++;
                
            }
        }
        troca(notas,termino-1,menoresEncontrados);
    }

    private static void troca(Nota[] notas, int de, int para)
    {
        Nota nota1=notas[de];
        Nota nota2=notas[para];
        notas[de]=nota2;
        notas[para]=nota1;
    }
}
