/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arquivosobreescrita;

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
public class arquivoEscrita {
      public void  escrever(ArrayList<String> texto)
        {
        for(String linhaTexto:texto)
                {
                    System.out.println(linhaTexto);
                }
        }
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
        Scanner scan = new Scanner(System.in);
        int aux;
        
        FileWriter fw;
          try {
              fw = new FileWriter(file);
              BufferedWriter bw = new BufferedWriter(fw);
        aux=scan.nextInt();
        for(String linha:arrayTexto)
        {
            //System.out.println("Linha "+linha);
            if(linha!=null && aux==1){
                
                bw.write(linha.toUpperCase());
                
            }else if(linha!=null && aux!=1)
            {
                bw.write(linha.toLowerCase());
                
            }
            bw.newLine();
        }
        bw.close();
        fw.close();
          } catch (IOException ex) {
              Logger.getLogger(arquivoEscrita.class.getName()).log(Level.SEVERE, null, ex);
          }
        
    }
}
