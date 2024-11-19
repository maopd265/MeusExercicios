/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringjava;

import java.util.Scanner;

/**
 *
 * @author Mauricio
 */
public class StringJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String pessoa;
        int cont=0;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Palavra");
        pessoa=entrada.nextLine();
        System.out.println("Caractere:");
        String caract = entrada.nextLine();
        for(int i=0;i<pessoa.length();i++)
        {
            char c = pessoa.charAt(i);
            System.out.println("c:"+c);
            
            if(c==caract.charAt(0))
            {
                cont++;
            }
            
        }
        System.out.println("Total de "+cont+" ocorrências");
    }
    
}
