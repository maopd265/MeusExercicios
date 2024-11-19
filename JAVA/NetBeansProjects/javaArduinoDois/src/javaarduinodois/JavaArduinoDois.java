/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaarduinodois;
import java.util.Scanner;
import jssc.SerialPort;
import jssc.SerialPortException;
/**
 *
 * @author Mauricio
 */
public class JavaArduinoDois {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Scanner entrada  = new Scanner(System.in);
        int valor;
        SerialPort serialPort  = new SerialPort("COM4");
        try
        {
            serialPort.openPort();
            serialPort.setParams(9600, 8, 1, 0);
             
            valor=entrada.nextInt();
            System.out.println("valor = "+ valor);
            serialPort.writeInt(valor);
            
            serialPort.closePort();
        }catch(SerialPortException e)
        {
            System.out.println(e);
        }
    }
    
}
