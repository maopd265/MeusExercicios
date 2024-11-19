/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arquivosobreescrita;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ArquivoSobreEscrita {

  
    public static void main(String[] args) {
        
        arquivoEscrita arq = new arquivoEscrita();
        File file = new File("C:\\Users\\Mauricio\\Desktop\\LIVROS\\JavaArquivos\\texto.txt");
        ArrayList<String> arrayTexto;
        arrayTexto=arq.carregar(file);
        //arq.escrever(arrayTexto);
        arq.escreverArq(file,arrayTexto);
        
    }
    
}
