import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
         
         
       System.out.println("Ola mundo");
       String palavra = "Ola,,mundo,!";
       palavra.split(",");
       while(palavra!=null)
       {
            System.out.println(palavra);
            palavra.split(",");
       }
        System.out.println("Ola"+System.lineSeparator()+"Mundo");
    }
   
}
