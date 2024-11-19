package br.com.alura.bytebank;

public class Conta implements IConta {

	private String nomeDaPessoa;
	private int numeroDaConta;
	@Override
	public int getNumeroConta() {
		// TODO Auto-generated method stub
		return this.numeroDaConta;
	}

	@Override
	public String getNomeDaPessoa() {
		// TODO Auto-generated method stub
		return this.nomeDaPessoa;
	}

}
