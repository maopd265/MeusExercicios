package br.com.alura.javaOito;

public class Curso {
	private int tempo;
	private String nome;
	public Curso(int tempo, String nome) {
		
		this.tempo = tempo;
		this.nome = nome;
	}
	public int getTempo() {
		return tempo;
	}
	public void setTempo(int tempo) {
		this.tempo = tempo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "CURSO:"+getNome()+",TEMPO:"+getTempo();
	}
}
