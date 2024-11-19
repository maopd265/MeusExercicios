package OrdenaDoisParam;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import teste.Conta;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nomePessoa;
		int numeroDaConta;
		Scanner scan = new Scanner(System.in);
		ArrayList<Conta> array = new ArrayList<Conta>();
		for(int i=0;i<3;i++) 
		{
			System.out.println("i="+i);
			scan.nextLine();
			System.out.println("Insira o nome da pessoa:");
			nomePessoa=scan.nextLine();
			
			System.out.println("Insira o número da conta:");
			numeroDaConta=scan.nextInt();
			Conta count = new Conta(nomePessoa,numeroDaConta);
			array.add(count);
		}
		for (Conta conta : array) {
			System.out.println(conta.toString());
		}
		System.out.println("----------------------------------------------");
//		Conta param = new Conta();
		Collections.sort(array,new Conta());
		Conta umaConta = new Conta();
		//array.sort(umaConta);
		Collections.reverse(array);
		for (Conta conta : array) {
			System.out.println(conta.toString());
		}
		 
		
	}

}
