/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package buscasubstring;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Mauricio
 */
public class BuscaSubstring {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File file = new File("C:\\Users\\Mauricio\\Desktop\\LIVROS\\JavaArquivos\\idSubstring.txt");
        String palavra = "Ola mundo!";
        String subString = "ABACAXI";
        int cont=0,totalDeLinhas=0;
         
        Arquivo arq  = new Arquivo();
        ArrayList<String> array= arq.carregar(file);
        boolean containsStr; 
         containsStr= palavra.indexOf(subString)>=0;
         for(String textoLinha :array)
         {
             containsStr= textoLinha.indexOf(subString)>=0;
             if(containsStr)
             {
                 System.out.println((textoLinha.split(subString, -1).length-1)+" vezes");
                 System.out.println("Ocorrência na linha :"+totalDeLinhas);
                 cont ++;
             }
             totalDeLinhas++;
         }
        
        System.out.println("Ocorrência de :" +cont+ " linhas");
        System.out.println("Total de linhas = "+ totalDeLinhas);
        
    }
    
}
