package br.com.pratica.javaOO;

public class Funcionario extends Pessoa {
	private Integer numeroDeIdentificacao;
	
	public Funcionario(String nomeDaPessoa, String cpf,Integer numero) {
		super(nomeDaPessoa, cpf);
		this.numeroDeIdentificacao=numero;
		// TODO Auto-generated constructor stub
	}

	public Integer getNumeroDeIdentificacao() {
		return numeroDeIdentificacao;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+" NUMERO: "+this.numeroDeIdentificacao;
	}
}
