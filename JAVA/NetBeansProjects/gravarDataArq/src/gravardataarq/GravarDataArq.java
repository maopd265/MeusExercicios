/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gravardataarq;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import java.util.Calendar;
/**
 *
 * @author Mauricio
 */
public class GravarDataArq {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File file = new File("dataLogin.txt");
        Calendar c = Calendar.getInstance();
		System.out.println("Data e Hora atual: "+c.getTime());
        try {
             
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write(c.getTime().toString());
            bw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println("Erro :"+e);
        }
    }
    
}
