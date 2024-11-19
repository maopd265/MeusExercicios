/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arquivoescreverinicio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mauricio
 */
public class Arquivo {
     public static ArrayList<String> carregar(File file)
    {
        ArrayList<String> texto = new ArrayList<>();
        String linha;
        try{
        FileReader fr = new FileReader(file);
        
            BufferedReader br = new BufferedReader(fr);
            linha=br.readLine();
            while(linha!=null)
            {
                  texto.add(linha);
                linha=br.readLine();
                   
             
            }
            br.close();
            fr.close();
            
        }catch(IOException e)
        {
            System.out.println("Error :"+e);
        }
        return texto;
    }
      public  void escreverArq(File file, ArrayList<String> arrayTexto)
    {
        
         
        
        FileWriter fw;
          try {
              fw = new FileWriter(file);
              BufferedWriter bw = new BufferedWriter(fw);
         
        for(String linha:arrayTexto)
        {
            //System.out.println("Linha "+linha);
            
                
                bw.write(linha);
                
             
            bw.newLine();
        }
        bw.close();
        fw.close();
          } catch (IOException e) {
              System.out.println("Error :" +e);
          }
    }
}
 
