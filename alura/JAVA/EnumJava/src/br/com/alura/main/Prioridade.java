package br.com.alura.main;

public enum Prioridade {
	MIN(1110), NORMAL(5), MAX(10);

	private int valor;
	

	Prioridade(int i) {
		// TODO Auto-generated constructor stub
		this.valor = i;
	}
	public int getValor() {
		return this.valor;
	}
}
