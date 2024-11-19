package br.com.alura.javaOito;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Curso> lista = new ArrayList<Curso>();
		lista.add(new Curso(123,"aasd"));
		lista.add(new Curso(1234,"basd"));
		lista.add(new Curso(1235,"casd"));
		lista.add(new Curso(1236,"dasd"));
		
		lista.stream().filter(s-> s.getTempo()>123).forEach(System.out::println);
		int sum = lista.stream().filter(c->c.getTempo()>123).mapToInt(Curso::getTempo).sum();
		 System.out.println(sum);
		 System.out.println(lista);
		 List<Curso> novaLista = lista.stream().filter(s->s.getTempo()>1234).toList();
		 List<Curso> cursosFiltrados = lista.stream()
				   .filter(c -> c.getTempo() > 123)
				   .collect(Collectors.toList());
		 System.out.println("Lista:"+lista);
		 System.out.println("Nova lista:"+novaLista);
		 System.out.println(cursosFiltrados);
	}

}
