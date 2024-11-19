package br.com.alura.estruturaDeDados;

public class Aluno {
	private String nome;

	public Aluno(String nome) {
		super();
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Aluno aluno = (Aluno) obj;
		return aluno.getNome().equals(this.nome);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.nome;
	}
}
