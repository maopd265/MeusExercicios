package br.com.alura.main;

public class Teste {

	public static void main(String[] args) {
	Prioridade pMin = Prioridade.MIN;	
	Prioridade pNormal = Prioridade.NORMAL;
	Prioridade pMax = Prioridade.MAX;
	
	
	System.out.println(pMin.name());
	System.out.println(pMin.ordinal());
	System.out.println(pMin.getValor());
	}
}
