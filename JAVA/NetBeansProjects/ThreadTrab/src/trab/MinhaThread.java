/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trab;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mauricio
 */
public class MinhaThread extends Thread{
    private String nome;
    private int tempo;
    public MinhaThread(String nome,int tempo)
    {
        this.nome=nome;
        this.tempo=tempo;
        start();
    }
    
    public void run()
    {
       
            try {
                 for(int i=0;i<6;i++)
        {
            System.out.println(nome+" contador "+ i);
                Thread.sleep(tempo);
        }
            } catch (InterruptedException ex) {
                Logger.getLogger(MinhaThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
}
