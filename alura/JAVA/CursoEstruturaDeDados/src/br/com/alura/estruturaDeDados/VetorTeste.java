package br.com.alura.estruturaDeDados;

public class VetorTeste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Aluno a1 = new Aluno("Mauricio");
		Aluno a2 = new Aluno("Ola mundo");
		Aluno a3 = new Aluno("aksjdaksdj");
		Vetor lista = new Vetor();
		
		lista.adiciona(a1);
		lista.adiciona(a2);
//		lista.remove(0);
		lista.adiciona(1,a1);
		lista.adiciona(0, a3);
		System.out.println(lista);
		System.out.println(lista.tamanho());
		System.out.println(lista.contem(a1));
		System.out.println(lista.contem(a3));
		System.out.println("Aluno:"+lista.buscaAluno(0));
		//System.out.println("Aluno:"+lista.buscaAluno(10));
	}

}
