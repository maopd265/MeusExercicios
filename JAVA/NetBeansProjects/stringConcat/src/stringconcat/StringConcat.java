/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringconcat;

import java.util.Scanner;

/**
 *
 * @author Mauricio
 */
public class StringConcat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String nome;
        String sobrenome;
        Scanner scan;
        scan = new Scanner(System.in);
        nome = scan.nextLine();
        sobrenome= scan.nextLine();
        nome=nome.concat(" "+sobrenome);
        System.out.println("Nome e sobrenome: "+nome);
    }
    
}
