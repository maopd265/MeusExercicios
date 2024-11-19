/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intentdesktop;

import java.io.IOException;

/**
 *
 * @author Mauricio
 */
public class IntentDesktop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
          ProcessBuilder process   = new ProcessBuilder();
          process.command("cmd.exe", "/c", "start www.google.com");
          
           
          process.start();
          try{
               
        Runtime rt = Runtime.getRuntime();
         rt.exec(new String[]{"cmd.exe","/c:","start"});
          
    }
        catch (IOException e)
{}
        Runtime.getRuntime().exec("notepad" );
       Runtime.getRuntime().exec("calc");
        
    }
    
}
