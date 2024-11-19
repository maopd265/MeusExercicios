public  abstract class Funcionario implements IPessoa {
    private String nome ;
    private int idade;
    private int codigoFuncionario;
    private static int totalDeFuncionarios=0;

    
    public Funcionario(int codigoFuncionario) {
        this.codigoFuncionario=codigoFuncionario;
        totalDeFuncionarios++;
        System.out.println(totalDeFuncionarios);
    }
    public int getTotalFuncionario()
    {
        return totalDeFuncionarios;
    }
    public void setNome(String nome)
    {
        this.nome=nome;
    }
    public String getNome()
    {
        return nome;
    }
    public void setIdade(int idade)
    {
        this.idade=idade;
    }
    public int getIdade()
    {
        return idade;
    }
    public void setCodigoFuncionario(int cod)
    {
        this.codigoFuncionario=cod;
    }
    public int getCodigoFuncionario()
    {
        return codigoFuncionario;
    }

    public abstract double SalarioFuncionario();
}
