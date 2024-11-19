package br.com.pratica.javaOO;

public class Pessoa {
	private String nomeDaPessoa;
	private String cpf;
	public Pessoa(String nomeDaPessoa, String cpf) {
		this.nomeDaPessoa = nomeDaPessoa;
		this.cpf = cpf;
	}
	public String getNomeDaPessoa() {
		return nomeDaPessoa;
	}
	public String getCpf() {
		return cpf;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "NOME DA PESSOA :"+this.nomeDaPessoa+" /CPF: "+this.cpf;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Pessoa pessoa =(Pessoa) obj;
		
			if (this.cpf.equals(pessoa.getCpf())) {
				return true;
			}
		
		return false;
	}
	
}
