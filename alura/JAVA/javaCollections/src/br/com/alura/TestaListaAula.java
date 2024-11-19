package br.com.alura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestaListaAula {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Aula> listaAula = new ArrayList<Aula>();
		listaAula.add(new Aula("csd", 123));
		listaAula.add(new Aula("asd", 2123));
		listaAula.add(new Aula("bsd", 123));
		listaAula.add(new Aula("asd", 3123));
		listaAula.add(new Aula("csd", 123));
		listaAula.add(new Aula("asd", 4123));
		listaAula.add(new Aula("dsd", 123));
		listaAula.forEach((aula) -> System.out.println(aula));
		System.out.println("-------------------------------");
		Collections.sort(listaAula, new Aula());
		// Collections.sort(listaAula,Comparator.comparing(Aula::getTempo));
		listaAula.forEach((aula) -> System.out.println(aula));

	}

}
