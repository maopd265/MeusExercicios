/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package stringtestejava;
import java.lang.Math;
import java.util.Date;
import javax.swing.JOptionPane;
/**
 *
 * @author Mauricio
 */
public class StringTesteJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //JOptionPane.showInputDialog("OLA MUNDO!");
        int primeiraVariavel, segundaVariavel;
        primeiraVariavel=1;
        segundaVariavel=2;
        System.out.println(primeiraVariavel+segundaVariavel);
        System.out.println(Integer.parseInt("1")+Integer.parseInt("2"));
        Date data = new Date();
        
        while(data.getMinutes()<53){
           data = new Date();
        System.out.println(data.getHours()+":"+data.getMinutes()+":"+data.getSeconds());
            try {
            Thread.sleep(1000);
            } catch (Exception e) {
            e.printStackTrace();
            }
        }
    }
    
}
