/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerescreverarq;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Mauricio
 */
public class LerEscreverArq {

    /**
     * @param args the command line arguments
     */
    public void lerArq(){}
    public void escreverArq(){}
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        String palavra = new String("Ola mundo!");
        System.out.println(palavra);
        Scanner entrada = new Scanner(System.in);
        File file;
        file = new File("C:\\Users\\Mauricio\\Desktop\\teste.txt");
        int i ;
        do{
            System.out.println("1 - ESCREVER ARQUIVO");
            System.out.println("2 - LER ARQUIVO");
            System.out.println("0 - SAIR");
            i = entrada.nextInt();
            
            switch(i)
            {
                        case 1:
                             FileWriter bw = new FileWriter(file,true);
                             BufferedWriter br;
                             br = new BufferedWriter(bw);
                             br.write(palavra);
                             br.newLine();
                             br.close();
                             bw.close();
                            break;
                        case 2:
                            FileReader fr = new FileReader(file);
                            BufferedReader buffReader;
                            buffReader = new BufferedReader(fr);
                            String linha =buffReader.readLine();
                            while(linha!=null)
                            {
                                System.out.println(linha);
                                 linha =buffReader.readLine();
                            }
                            break;
                        case 0: break;
            }
        }while(i!=0);
        
        
        
        
        
        
        
        
       
        
        
        
    }
    
}
