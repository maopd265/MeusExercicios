package br.com.alura.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate data = LocalDate.now();
		System.out.println(data);
		LocalDate olimpiada = LocalDate.of(2022,Month.DECEMBER,26);
		LocalDate proximasOlimpiadas = olimpiada.plusYears(4);
		Period periodo = Period.between(data, olimpiada);
		System.out.println(periodo.getYears()+" anos"+periodo.getMonths()+"meses e "+periodo.getDays()+ " dias");
		System.out.println(proximasOlimpiadas);
		
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
		LocalDateTime dataAgora=LocalDateTime.now();
		System.out.println(dataAgora.format(formatador));
		
		LocalDate dataProgramada = LocalDate.of(2099, 1, 25);
		DateTimeFormatter formatadorNovo = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println(dataProgramada.format(formatadorNovo));
	}

}
