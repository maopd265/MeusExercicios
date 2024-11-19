package br.com.alura.estruturaDeDados;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Pilha {
	public static void main(String[] args) {
		Stack<String> pilha = new Stack<String>();
		pilha.add("Ola mundo");
		pilha.add("Alo mundo");
		System.out.println(pilha);
		Queue<String> fila = new LinkedList<String>();
		fila.add("asd");
		fila.add("kasjdk");
		System.out.println(fila);
		fila.remove();
		System.out.println(fila);
	}
}
