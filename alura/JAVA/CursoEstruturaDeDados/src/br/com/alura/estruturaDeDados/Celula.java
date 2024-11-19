package br.com.alura.estruturaDeDados;

public class Celula {
	private Object obj;
	private Celula prox;
	private Celula anterior;
	public Celula(Object obj, Celula prox) {
		 
		this.obj = obj;
		this.prox = prox;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	public Celula getProx() {
		return prox;
	}
	 public void setProx(Celula prox) {
		this.prox = prox;
	}
	 public void setAnterior(Celula anterior) {
		this.anterior = anterior;
	}
	 public Celula getAnterior() {
		return anterior;
	}
	
}
