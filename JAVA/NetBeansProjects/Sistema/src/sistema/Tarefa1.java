/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mauricio
 */
public class Tarefa1 implements Runnable{
    
    
    
    @Override
    public void run()
    {
        System.out.println("Thread 1");
        for(int i=0;i<500;i++)
        {
            System.out.println("Thread número :"+i);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Tarefa1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
