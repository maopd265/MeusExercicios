package br.com.alura;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;
public class Curso {
	private String nome;
	private String instrutor;
	private List<Aula> listaAula= new LinkedList<Aula>();
	private Set<Aluno> alunos=new TreeSet<Aluno>(new Aluno());
	private Map<Integer,Aluno> matriculaParaAluno = new HashMap<>();
	public Curso(String nome, String instrutor) {
		this.nome = nome;
		this.instrutor = instrutor;
	}

	public String getInstrutor() {
		return instrutor;
	}

	public String getNome() {
		return nome;
	}

	public List<Aula> getListaAula() {
		return Collections.unmodifiableList(listaAula);
	}
	public void adicionaAula(Aula aula) {
		listaAula.add(aula);
	}
	public Set<Aluno> getAlunos() {
		return Collections.unmodifiableSet(alunos);
	}
	public void adicionaAluno(Aluno aluno) {
		alunos.add(aluno);
		matriculaParaAluno.put(aluno.getNumeroMatricula(), aluno);
	}

	public boolean estaMatriculado(Aluno aluno) {
		// TODO Auto-generated method stub
		
		return this.alunos.contains(aluno);
	}

	public void ordenaAula() {
		// TODO Auto-generated method stub
		this.listaAula.sort(Comparator.comparing(Aula::getTitulo));
		
	}

	public Aluno buscaMatriculado(int i) {
		// TODO Auto-generated method stub
		if (!matriculaParaAluno.containsKey(i))
			throw new NoSuchElementException("Não encontrou o elemento na lista!");
			
		 
		return matriculaParaAluno.get(i);
		
		
		
		
//		for (Aluno aluno : alunos) {
//			if(aluno.getNumeroMatricula()==i) {
//				return aluno;
//			}
//		}
//		 throw new NoSuchElementException("Matricula não encontrada! " +i);
	}

	 

	 
}
