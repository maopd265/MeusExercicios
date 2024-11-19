 

 

public class Programador extends Funcionario {
    private double Salario;
     
    public Programador(int codigoFunc) {
        super(codigoFunc);
    }
    public double SalarioFuncionario()
    {
        this.Salario=8000;
        return Salario;
    }
     
}
