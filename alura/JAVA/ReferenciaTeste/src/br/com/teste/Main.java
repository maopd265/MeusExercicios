package br.com.teste;
import br.com.alura.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Conta conta = new Conta("asd",123);
		System.out.println(conta);
		Conta contaDois = conta;
		contaDois.setNomePessoa("asdlaksdlkasdlk");
		System.out.println(conta==contaDois);
		System.out.println(conta);
	}

}
