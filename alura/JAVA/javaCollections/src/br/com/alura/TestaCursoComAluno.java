package br.com.alura;

import java.util.Iterator;
import java.util.Set;
public class TestaCursoComAluno {

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
		javaCollection.ordenaAula();
		for (Aula aula : javaCollection.getListaAula()) {
			System.out.println(aula);
		}
		Aluno aluno = new Aluno("Ola mundo",1254);
		Aluno alunoDois = new Aluno("Alo mundo",1254);
		Aluno alunoTres = new Aluno("Mundo",1254);
		 javaCollection.adicionaAluno(aluno);
		 javaCollection.adicionaAluno(alunoDois);
		 javaCollection.adicionaAluno(alunoTres);
		 javaCollection.adicionaAluno(new Aluno("Alo mundo",312));
		 
		 
		 
		 javaCollection.getAlunos().forEach((alunoLista)->System.out.println(alunoLista));
		 System.out.println("O aluno "+aluno+" está matriculado?");
//		 System.out.println(javaCollection.getAlunos().contains(alunoTres));
		 
		 System.out.println(javaCollection.estaMatriculado(aluno));
//		 System.out.println(aluno.hashCode()==alunoDois.hashCode());
		Set<Aluno> setAluno = javaCollection.getAlunos();
		Iterator<Aluno> iterador = setAluno.iterator();
		while (iterador.hasNext()) {
			Aluno aluno2 = (Aluno) iterador.next();
			System.out.println("iterator:"+aluno2);
			
		}
		
		System.out.println("Quem é o aluno com matricula 312?");
		Aluno buscaAluno = javaCollection.buscaMatriculado(312);
		System.out.println("É o aluno "+buscaAluno);
	}

}
