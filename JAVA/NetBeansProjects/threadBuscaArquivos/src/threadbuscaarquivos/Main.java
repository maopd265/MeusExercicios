/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package threadbuscaarquivos;

/**
 *
 * @author Mauricio
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here;
        threadArq tarq1 = new threadArq("C:\\Users\\Mauricio\\Desktop\\LIVROS\\JavaArquivos\\valores.txt");
        threadArq tarq2 = new threadArq("C:\\Users\\Mauricio\\Desktop\\LIVROS\\JavaArquivos\\valores2.txt");
        threadArq tarq3 = new threadArq("C:\\Users\\Mauricio\\Desktop\\LIVROS\\JavaArquivos\\valores3.txt");
    }
    
}
