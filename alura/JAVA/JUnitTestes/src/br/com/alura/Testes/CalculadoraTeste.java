package br.com.alura.Testes;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

public class CalculadoraTeste {
	@Test
	 void somaNumerosPositivos() {
		// TODO Auto-generated method stub
		Calculadora calc = new Calculadora();
		 int soma = calc.soma(3, 7);
		 
		 
	 assertEquals(1000, soma);
	}
}
