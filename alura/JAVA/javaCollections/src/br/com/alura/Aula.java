package br.com.alura;

import java.util.Comparator;

public class Aula implements Comparator<Aula> {
	private String titulo;
	private int tempo;

	public Aula() {
		// TODO Auto-generated constructor stub
	}

	public Aula(String titulo, int tempo) {

		this.titulo = titulo;
		this.tempo = tempo;
	}

	public int getTempo() {
		return tempo;
	}

	public String getTitulo() {
		return titulo;
	}

	@Override
	public int compare(Aula o1, Aula o2) {
		// TODO Auto-generated method stub
		if (o1.getTitulo().compareTo(o2.getTitulo()) == 0) {
			return Integer.compare(o1.getTempo(), o2.getTempo());
		}
		return o1.getTitulo().compareTo(o2.getTitulo());
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "TITULO:" + this.titulo + ",TEMPO:" + this.tempo;
	}
//	 public void setTempo(int tempo) {
//		this.tempo = tempo;
//	}
//	 public void setTitulo(String titulo) {
//		this.titulo = titulo;
//	}
}
