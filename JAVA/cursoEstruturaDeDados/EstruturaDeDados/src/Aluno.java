public class Aluno {
    private String nome;
    public Aluno(String nome) {
        this.nome=nome;
    }
    public String getNome() {
        return nome;
    }
    @Override
    public boolean equals(Object obj) {
        Aluno alunoEq = (Aluno) obj;
        return alunoEq.getNome().equals(this.nome);
        // TODO Auto-generated method stub
        
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return nome;
    }
}
