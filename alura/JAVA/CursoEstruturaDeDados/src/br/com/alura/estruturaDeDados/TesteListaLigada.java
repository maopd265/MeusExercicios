package br.com.alura.estruturaDeDados;

public class TesteListaLigada {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListaLigada lista = new ListaLigada();
		lista.adicionaNoComeco("asd");
		lista.adicionaNoComeco("aasd");
		lista.adicionaNoComeco("sasd");
		lista.adicionaNoComeco("dasd");
		lista.adicionaNoComeco("aaasd");
		lista.adicionaNoComeco("ssasd");
		lista.adicionaNoComeco("dddasd");
		lista.adiciona("Mauricio");
		lista.adiciona(2, "Mauricio");
		System.out.println(lista);
		System.out.println("Tamanho da lista:"+lista.tamanho());
	}

}
