package br.com.alura.tdd.modelo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class Funcionario {

	private String nome;
	private LocalDate dataAdmissao;
	private BigDecimal salario;

	public Funcionario(String nome, LocalDate dataAdmissao, BigDecimal salario) {
		this.nome = nome;
		this.dataAdmissao = dataAdmissao;
		this.salario = salario;
	}

	public String getNome() {
		return nome;
	}

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void reajusteSalario(BigDecimal reajuste) {
		// TODO Auto-generated method stub
		this.salario=this.salario.add(reajuste);
		arredondarSalario();		
		
	}

	private void arredondarSalario() {
		// TODO Auto-generated method stub
		this.salario=salario.setScale(2, RoundingMode.HALF_UP);
	}

}
