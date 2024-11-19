/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package buscadigitostxt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mauricio
 */
public class BuscaDigitosTxt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File file = new File("C:\\Users\\Mauricio\\Desktop\\LIVROS\\JavaArquivos\\valores.txt");
        FileReader fr;
        String linha;
        int cont=0,sum=0;
        try {
            fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            linha=br.readLine();
            while(linha!=null)
            {
                for(int i=0;i<linha.length();i++)
                {
                    char c = linha.charAt(i);
                    if(Character.isDigit(c))
                    {
                       cont++; 
                       sum+=Character.getNumericValue(c);
                    }
                }
                linha=br.readLine();
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BuscaDigitosTxt.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BuscaDigitosTxt.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        System.out.println("Soma :"+sum);
        System.out.println("Total de digitos encontrados = "+cont);
    }
    
}
