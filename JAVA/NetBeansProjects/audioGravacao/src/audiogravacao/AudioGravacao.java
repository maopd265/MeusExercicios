/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audiogravacao;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
import javax.swing.*;
import javax.sound.sampled.*;
import java.io.*;
/**
 *
 * @author User
 */
public class AudioGravacao {

   
    public static void main(String[] args)  {
       new AudioGravacao().som();
       
   
 }
    public void som() {
        try {
            // Carrega o arquivo de áudio (não funciona com .mp3, só .wav)
        String resource = "./Gravacao.wav";
        InputStream input = getClass().getResourceAsStream(resource);
        Clip oClip = AudioSystem.getClip();
        AudioInputStream audioInput = AudioSystem.getAudioInputStream(input);
        oClip.open(audioInput);
        while(oClip.getMicrosecondPosition()<oClip.getMicrosecondLength())
        {
         oClip.loop(0); // Toca uma vez
        }
       
          
           System.out.println("Tempo total : "+oClip.getMicrosecondLength()/1000000+" segundos");
        
        //oClip.loop(Clip.LOOP_CONTINUOUSLY); // Toca continuamente (para o caso de músicas)
 
        // Para a execução (senão o programa termina antes de você ouvir o som)
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
         
            }
        });
        } catch (Exception e) {
            
        }
         
    }
    
    
     
}
