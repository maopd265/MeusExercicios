/**
 * Diretor
 */
public class Diretor extends Funcionario {
    private double Salario;
    
    
    public Diretor(int codigoFunc) {
        super(codigoFunc);
    }
    public double SalarioFuncionario()
    {
        this.Salario=5000;
        return Salario;

    }
}