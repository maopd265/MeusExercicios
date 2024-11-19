/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arquivoescreverinicio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mauricio
 */
public class ArquivoEscreverInicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       File file = new File("C:\\Users\\Mauricio\\Desktop\\LIVROS\\JavaArquivos\\texto.txt");
        ArrayList<String> array;
        int i,numLinha;
        Scanner scan = new Scanner(System.in);
       Arquivo arq = new Arquivo();
       array=arq.carregar(file);
       do
       {
           System.out.println("1 - Inserir linha final");
           
           System.out.println("2 - Inserir linha em determinada posição do arraylist");
           System.out.println("0 -SAIR");
           i=scan.nextInt();
           switch(i)
           {
               case 1 :
                   array.add(array.size(), "Ola mundo 1");
                   arq.escreverArq(file,array);
                   break;
               case 2 :
                   System.out.println("Qual linha :");
                   numLinha= scan.nextInt();
                   array.add(numLinha,"Ola mundo 2");
                    arq.escreverArq(file,array);
                   break;
               case 0 : break;
           }
           
       }while(i!=0); 
    }
    
}
