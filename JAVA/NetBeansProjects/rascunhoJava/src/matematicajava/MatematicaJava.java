/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package matematicajava;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Mauricio
 */
public class MatematicaJava{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String texto = "Ola mundo Ola";
        String[] text;
        text=texto.split("Ola");
        System.out.println(text[0]);
        System.out.println(text[1]);
        
        System.out.println(texto.split("Ola",-1).length-1);
       String[] frases ={"Facebook",
           "Twitter","Google"};
       int n = new Random().nextInt(frases.length);
      
           System.out.println("Palavra  "+(n+1)+": "+frases[n]);   
              if(frases[n].indexOf("Facebook")==0)
               {
                   System.out.println("True");
               }else
               {
                   System.out.println("False");
               }
               
       }
    
}
