package br.com.alura.estruturaDeDados;

public interface IListaLigada {

	void adiciona(Object element);
	void adiciona(int posicao,Object element);
	Object pegaElemento(int posicao);
	void remove(int posicao);
	int tamanho();
	boolean contem(Object obj);
	void adicionaNoComeco(Object element);
}
