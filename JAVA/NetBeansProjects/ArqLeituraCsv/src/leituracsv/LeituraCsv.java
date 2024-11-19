/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leituracsv;
import java.io.*;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
/**
 *
 * @author Mauricio
 */
public class LeituraCsv 
{

     
    public static void main(String[] args) throws FileNotFoundException, IOException, SQLException {
      
       ArrayList<String> array = new ArrayList<>();
      File file = new File("C:\\Users\\Mauricio\\Desktop\\teste.txt");
      try
      {
          FileReader fr = new FileReader(file);
          BufferedReader br = new BufferedReader(fr);
          String linha;
          linha =br.readLine();
          while(linha!=null)
          {
              array.add(linha);
              linha = br.readLine();
          }
          
      }catch(NullPointerException e)
      {
          System.out.println("Error:"+e);
      }
      
      try{
      String[] texto;
       for(String c : array) {
        System.out.println(c);
        texto=c.split(",");
           System.out.println("1-"+texto[0]);
           System.out.println("2-"+texto[1]);
           System.out.println("3-"+texto[2]);
          Connection conexao= new bancoDeDados().getConnection();
            
               String sql="insert into pessoa(nome,sobrenome,dataatual,cidade)values('" +texto[0]+"','"+texto[1]+"','"+texto[2]+"','"+"Caxias" + "'); ";
          
            PreparedStatement statement= conexao.prepareStatement(sql);
            statement.execute();
            conexao.close();
        }
      }catch(ArrayIndexOutOfBoundsException e)
      {
          System.out.println("Error: "+e);
      }
      
         
       
       // escrever(array);
    }
   public static void escrever(ArrayList<String> array)
   {
       System.out.println("Escrita de arquivo");
        for(String c : array) {
        System.out.println(c);
        }
   } 
}
