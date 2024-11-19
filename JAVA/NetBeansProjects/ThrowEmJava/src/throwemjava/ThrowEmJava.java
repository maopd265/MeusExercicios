/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package throwemjava;

/**
 *
 * @author Mauricio
 */
public class ThrowEmJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       
        try
        {
             ArithmeticException ae = new ArithmeticException();
        throw ae;
        
        }catch (ArithmeticException e)
        {
            e.printStackTrace();
            System.out.println("");
        System.out.println("depois do try");
        }
        
    }
    
}
