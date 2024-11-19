package br.com.alura;

public class Conta {
	private String nomePessoa;
	private int numeroConta;
	 
	public Conta(String nomePessoa, int numeroConta) {
		 
		this.nomePessoa = nomePessoa;
		this.numeroConta = numeroConta;
	}
	public String getNomePessoa() {
		return nomePessoa;
	}
	public int getNumeroConta() {
		return numeroConta;
	}
	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}
	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Nome:"+nomePessoa+",Número da conta:"+numeroConta;
	}
}
