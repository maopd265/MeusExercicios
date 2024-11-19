/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaarduino;
import java.util.Scanner;
import jssc.SerialPort;
import jssc.SerialPortException;
/**
 *
 * @author Mauricio
 */
public class JavaArduino {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner entrada  = new Scanner(System.in);
        
        SerialPort serialPort  = new SerialPort("COM4");
        try
        {
            serialPort.openPort();
            serialPort.setParams(9600, 8, 1, 0);
            int closePort = 1;
            while(closePort<=10)
            {
                String informacao=serialPort.readString(12);
                System.out.println(informacao + " - " + closePort );
                closePort++;
            }
            
            serialPort.closePort();
        }catch(SerialPortException e)
        {
            System.out.println(e);
        }
        
    }
    
}
