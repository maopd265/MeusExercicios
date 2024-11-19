package br.com.alura.estruturaDeDados;

public class ListaLigada implements IListaLigada {

	private Celula primeiro = null;
	private Celula ultimo = null;
	private int totalElementos = 0;

	@Override
	public void adiciona(Object element) {
		// TODO Auto-generated method stub
		if (totalElementos == 0) {
			adicionaNoComeco(element);
		} else {
			Celula celula = new Celula(element, null);

			this.ultimo.setProx(celula);
			this.ultimo = celula;
			this.totalElementos++;
		}
	}

	@Override
	public void adicionaNoComeco(Object element) {
		// TODO Auto-generated method stub
		Celula celula = new Celula(element, primeiro);

		this.primeiro = celula;

		if (this.totalElementos == 0) {
			this.ultimo = this.primeiro;
		}
		this.totalElementos++;
	}

	@Override
	public void adiciona(int posicao, Object element) {
		// TODO Auto-generated method stub
		if (posicao == 0) {
			adicionaNoComeco(element);
		} else if (posicao == this.totalElementos) {
			adiciona(element);
		} else {
			Celula anterior = pegaCelula(posicao - 1);
			Celula celulaNova = new Celula(element, anterior.getProx());
			anterior.setProx(celulaNova);
			this.totalElementos++;
		}

	}

	private boolean posicaoOcupada(int posicao) {
		return posicao >= 0 && posicao < this.totalElementos;
	}

	public Celula pegaCelula(int posicao) {
		if (!posicaoOcupada(posicao)) {
			throw new IllegalArgumentException("Posição inexistente!");
		}
		Celula atual = primeiro;
		for (int i = 0; i < posicao; i++) {
			atual = atual.getProx();
		}
		return atual;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub

		if (this.totalElementos == 0) {
			return "[]";
		}
		Celula atual = primeiro;
		StringBuilder builder = new StringBuilder("[");
		for (int i = 0; i < totalElementos; i++) {
			builder.append(atual.getObj());
			if (i < totalElementos - 1)
				builder.append(",");
			atual = atual.getProx();
		}
		builder.append("]");
		return builder.toString();
	}

	@Override
	public Object pegaElemento(int posicao) {
		// TODO Auto-generated method stub
		return this.pegaCelula(posicao).getObj();
	}

	@Override
	public void remove(int posicao) {
		// TODO Auto-generated method stub

	}

	@Override
	public int tamanho() {
		// TODO Auto-generated method stub
		return this.totalElementos;
	}

	@Override
	public boolean contem(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	public void removeNoComeco(Object obj) {
		if (this.totalElementos == 0) {
			throw new IllegalArgumentException("Lista vazia!");
		}
		this.primeiro = this.primeiro.getProx();
		this.totalElementos--;

		if (this.totalElementos == 0) {
			this.ultimo=null;
		}
	}
}
