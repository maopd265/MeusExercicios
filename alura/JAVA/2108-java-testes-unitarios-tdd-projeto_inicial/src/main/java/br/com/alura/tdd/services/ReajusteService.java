package br.com.alura.tdd.services;

import java.math.BigDecimal;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteService {

	public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
		// TODO Auto-generated method stub
		
			BigDecimal percentual = desempenho.percentualReajuste();
			BigDecimal reajuste=funcionario.getSalario().multiply(percentual);
			funcionario.reajusteSalario(reajuste);
		
	}

}
