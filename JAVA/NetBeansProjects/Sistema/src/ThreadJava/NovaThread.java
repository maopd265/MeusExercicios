/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadJava;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mauricio
 */
public class NovaThread extends Thread {
    String nome;
    public NovaThread(String nome)
    {
        this.nome=nome;
        this.start();
    }
    
    @Override
    public void run()
    {
        
        System.out.println(this.nome);
        for(int i =0;i<1000;i++)
        {
            System.out.println(this.nome+" i = "+i);
            try {
                this.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(NovaThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                
    }
}
