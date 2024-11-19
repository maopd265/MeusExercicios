/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buscasubstring;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mauricio
 */
public class Arquivo {
public ArrayList<String> carregar(File file){
   ArrayList<String> arrayStr = new ArrayList<>();
    try {
        FileReader fr = new FileReader(file);
        String linha;
         BufferedReader br = new BufferedReader(fr);
        linha = br.readLine();
        while(linha!=null)
        {
            System.out.println("linha :"+ linha);
            arrayStr.add(linha);
            linha = br.readLine();
            
        }
        
        
        
        
        br.close();
        fr.close();
        
    } catch (FileNotFoundException ex) {
        Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
    }
    
 return arrayStr;  
}    
}
