/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testejava;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
/**
 *
 * @author Mauricio
 */
public class TesteJava {

    /**
     * @param args the command line arguments
     */
 
    public static void main(String[] args) {
        
       int[] vetor = new int[100];
       Random random = new Random();
       for(int i=0;i<vetor.length;i++)
       {
           System.out.println("i:"+i);
           vetor[i]=random.nextInt(100);
           System.out.println("vetor[i]"+vetor[i]);
       }
       Arrays.sort(vetor);
       for(int i=0;i<vetor.length;i++)
       {
           System.out.println("i:"+i);
           
           System.out.println("vetor[i]"+vetor[i]);
       }
               
// TODO code application logic here
    }
    
}
