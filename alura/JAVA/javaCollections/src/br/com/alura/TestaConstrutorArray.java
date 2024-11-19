package br.com.alura;
import java.util.List;
import java.util.ArrayList;
public class TestaConstrutorArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Curso javaCollection = new Curso("Dominando as coleções do Java","Asd");
		//javaCollection.getListaAula().add(new Aula("csd", 123));
		javaCollection.adicionaAula(new Aula("csd", 123));
		javaCollection.adicionaAula(new Aula("zcsd", 123));
		javaCollection.adicionaAula(new Aula("vcsd", 123));
		javaCollection.adicionaAula(new Aula("dcsd", 123));
		javaCollection.adicionaAula(new Aula("scsd", 123));
		javaCollection.adicionaAula(new Aula("acsd", 123));
		for (Aula aula : javaCollection.getListaAula()) {
			System.out.println(aula);
		}
		List<Aula> lista = javaCollection.getListaAula();
		List<Aula> listaAula = new ArrayList<Aula>(lista);
		listaAula.add(new Aula("zcsd", 123));
		
		
		System.out.println(javaCollection.getListaAula());
		System.out.println(listaAula);
	}

}
