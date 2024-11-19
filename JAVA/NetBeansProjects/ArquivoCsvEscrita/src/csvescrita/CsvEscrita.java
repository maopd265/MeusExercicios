/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csvescrita;
import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Mauricio
 */
public class CsvEscrita {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File file = new File ("C:\\Users\\Mauricio\\Desktop\\teste.txt");
        Pessoa pessoa = new Pessoa();
        Scanner entrada = new Scanner(System.in);
        FileWriter fw;
        try {
            fw = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(fw);
            System.out.println("Digite o nome da pessoa:");
            pessoa.setNome(entrada.nextLine());
            System.out.println("Sobrenome:");
            pessoa.setSobrenome(entrada.nextLine());
            System.out.println("Data:");
            pessoa.setDataNasc(entrada.nextLine());
            System.out.println("Cidade");
            pessoa.setCidade(entrada.nextLine());
            bw.write(pessoa.getNome()+" "+pessoa.getSobrenome()+","+pessoa.getDataNasc()+","+pessoa.getCidade());
            
            bw.newLine();
            bw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println("Exception : "+e);
        }
        
        
    }
    
}
