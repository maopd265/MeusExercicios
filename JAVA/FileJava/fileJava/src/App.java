import java.io.File;
import java.io.FileWriter;

public class App {
    public static void main(String[] args) throws Exception {
        
        Funcionario func = new Diretor(124587);
        Funcionario func2= new Programador(78780406);
        System.out.println("Diretor:"+func.SalarioFuncionario());
        System.out.println("Programador:"+func2.SalarioFuncionario());
        File file = new File("C://Users//Mauricio//Desktop//LIVROS//JavaArquivos//texto.txt");
        FileWriter fw = new FileWriter(file,true);
        fw.write("Diretor:"+func.SalarioFuncionario());
         
        fw.write(System.lineSeparator()+"Programador:"+func2.SalarioFuncionario());
        fw.close();
        //  ArrayList<Funcionario> arrayFunc = new ArrayList<>();
        //  arrayFunc.add(func);
        //  arrayFunc.add(func2);
        //  System.out.println(arrayFunc);
        
         
    }
}
