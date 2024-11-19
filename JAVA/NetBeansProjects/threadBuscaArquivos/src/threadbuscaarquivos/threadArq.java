/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threadbuscaarquivos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mauricio
 */
public class threadArq extends Thread{
    private String dir;
    public threadArq(String dir)
    {
        this.dir=dir;
        start();
    }
    
    public void run()
    {
         FileReader fr;
        String linha;
        int cont=0,sum=0,totalDeLinhas=0;
        try {
            fr = new FileReader(dir);
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
                totalDeLinhas++;
                linha=br.readLine();
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
             System.out.println("Error "+e);
        } catch (IOException e) {
           System.out.println("Error "+e);
        }
        
        System.out.println("Arq:"+dir+" Soma :"+sum+" Total de digitos encontrados = "+cont +" Total de linhas:"+totalDeLinhas);
        
    }
    
}
