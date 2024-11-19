import java.util.ArrayList;
import java.util.LinkedList;

import javax.sound.sampled.SourceDataLine;

public class App {
    public static void main(String[] args) throws Exception {
       
        String mensagem = "Ola mundo";
        System.out.println(mensagem.length());
        System.out.println(mensagem.toUpperCase());
        String mensagemDois = "Boa noite";
        System.out.println(mensagem.concat(mensagemDois));
        int a =2,b=3 ;
        System.err.println(Math.max(a,b));
        System.out.println(Math.random());  
        String [] arrayString={"Volvo","Bmw","Opala","Ford"};
        System.out.println("Tamanho do array de string ="+arrayString.length);;
        

        double salario = 1500.1457d;
        double sal1,sal2,sal3;
        salario= salario + (salario * 0.1);

        System.out.println("1:"+salario);
        salario = 1500.1457d;
        salario*=0.1;
        System.out.println("2:"+salario);
        salario = 1500.1457d;
        salario =salario *0.1;
        System.out.println("3:"+salario);
        Menu menu = new Menu();
        menu.switchMenu();
    }
}
