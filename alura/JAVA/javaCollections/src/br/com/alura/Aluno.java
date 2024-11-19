package br.com.alura;
import java.util.Comparator;
public class Aluno implements Comparator<Aluno>{
	private String nome;
	private int numeroMatricula;
	public Aluno(String nome, int numeroMatricula) {
		this.nome = nome;
		this.numeroMatricula = numeroMatricula;
	}
	public Aluno() {
		// TODO Auto-generated constructor stub
		
	}
	public String getNome() {
		return nome;
	}
//	public void setNome(String nome) {
//		this.nome = nome;
//	}
	public int getNumeroMatricula() {
		return numeroMatricula;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "NOME:"+this.nome+", NUMERO:"+this.numeroMatricula;
	}
//	public void setNumeroMatricula(int numeroMatricula) {
//		this.numeroMatricula = numeroMatricula;
//	}
	@Override
	public int compare(Aluno o1, Aluno o2) {
		// TODO Auto-generated method stub
		
		return o1.getNome().compareTo(o2.getNome())==0?Integer.compare(o1.getNumeroMatricula(), o2.getNumeroMatricula()):o1.getNome().compareTo(o2.getNome());
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.nome.hashCode();
	}
	 
	
}
