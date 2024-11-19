package br.com.alura.tdd.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.BonusService;

public class ReajusteServiceTest {
	private Funcionario funcionario;
	private ReajusteService reajuste;

	@BeforeEach
	public void inicializar() {
		System.out.println("Inicializa");
		reajuste = new ReajusteService();
		funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000"));
	}

	@AfterEach
	public void finaliza() {
		System.out.println("Fim");
	}

	@BeforeAll
	public static void inicioDeTodosTestes() {
		System.out.println("Inicio dos testes");
	}

	@AfterAll
	public static void fimDeTodosTestes() {
		System.out.println("Fim dos testes");
	}
	
	@Test
	public void reajusteDeZeroPorcentoParaSalarioMuitoAlto() {
		BonusService service = new BonusService();

		// assertEquals(new BigDecimal("0.00"), bonus);
		assertThrows(IllegalArgumentException.class,
				() -> service.calcularBonus(new Funcionario("Asd", LocalDate.now(), new BigDecimal("321313"))));
//		try {
//			service.calcularBonus(new Funcionario("Asd",LocalDate.now(),new BigDecimal("321313")));
//			fail("Não ocorreu Exception!");
//		} catch (Exception e) {
//			// TODO: handle exception
		// assertEquals("Funcionário com salário acima de R$10000 não pode receber
		// bonus!",e.getMessage());
//			
//		}
	}

	@Test
	public void reajusteDeTresPorcento() {
//		this.inicializar();
		reajuste.concederReajuste(funcionario, Desempenho.A_DESEJAR);
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
	}

	@Test
	public void reajusteDeQuinzePorcento() {
//		this.inicializar();
		reajuste.concederReajuste(funcionario, Desempenho.BOM);
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
	}

	@Test
	public void reajusteDeVintePorcento() {
//		this.inicializar();
		reajuste.concederReajuste(funcionario, Desempenho.OTIMO);
		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
	}
}
