package Arraylist;
import teste.Conta;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
 

public class MainList {
	 public static void main(String[] args) {
		 ArrayList<Conta> array= new ArrayList<Conta>();
		 	Conta contaUm = new Conta("babc",123);
			Conta contaDois=new Conta("abca",231);
			array.add(contaUm);
			array.add(contaDois);
			for(int i=0;i<array.size();i++) {
				System.out.println(array.get(i).toString());
			}
			
			 
			Conta conta = new Conta();
			Collections.sort(array,conta);
			
			ArrayList<String> teste = new ArrayList<String>();
			 
//			 List<Conta> list = new ArrayList<Conta>();
			teste.add("Ola");
			teste.add("Alo");
			teste.sort(null);
			System.out.println(teste);
			System.out.println("Tamanho :"+array.size());
			//array.remove(1);
			System.out.println("Tamanho :"+array.size());
			for (Conta object : array) {
				System.out.println(object.toString());
				
			}
			ArrayList arrayGeneric = new ArrayList();
			arrayGeneric.add(1);
			arrayGeneric.add(true);
			arrayGeneric.add(1.2);
			arrayGeneric.add("Ola mundo");
			 
			for(int i=0;i<arrayGeneric.size();i++) 
			{
				System.out.println(arrayGeneric.get(i).toString());
			} 
			
			
			
			
	}
}
