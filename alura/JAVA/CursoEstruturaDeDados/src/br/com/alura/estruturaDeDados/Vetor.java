package br.com.alura.estruturaDeDados;

import java.util.Arrays;


public class Vetor {
	private Aluno aluno[] = new Aluno[1];
	private int totalAlunos=0;
	
	private boolean posicaoValida(int posicao) {
		// TODO Auto-generated method stub
		return posicao>=0 && posicao<=totalAlunos;
	}
	private boolean posicaoOcupada(int posicao) {
		// TODO Auto-generated method stub
		return posicao>=0 && posicao<totalAlunos;
	}
	public void garanteEspaco() {
		if(totalAlunos==aluno.length) {
			Aluno[] novoArray = new Aluno[totalAlunos*2];
			for (int i = 0; i < aluno.length; i++) {
				novoArray[i]=aluno[i];
			}
			this.aluno=novoArray;
		}
		
		
	}
	public Aluno buscaAluno(int posicao) {
		if(!this.posicaoOcupada(posicao)) {
			throw new IllegalArgumentException("Posição inválida!");
		}
		return aluno[posicao];
	}
	public void adiciona(int posicao,Aluno a1) {
		this.garanteEspaco();
		if(!posicaoValida(posicao)) {
			throw new IllegalArgumentException("Posição inválida!");
		}
		for (int i = totalAlunos-1; i >= posicao; i--) {
			aluno[i+1]=aluno[i];
			
		}
		aluno[posicao]=a1;
		totalAlunos++;

	}
	public void remove(int posicao) {
		for (int i = posicao; i < totalAlunos; i++) {
			this.aluno[i]=aluno[i+1];
		}
		totalAlunos--;
		this.aluno[totalAlunos]=null;
	}
	public boolean contem(Aluno a1) {
		for (int i = 0; i < totalAlunos; i++) {
			if (aluno[i].equals(a1)) {
				return true;
				
			}
		}
		
		return false;
	}
	public int tamanho() {
		return this.totalAlunos;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Arrays.toString(aluno);
	}

	public void adiciona(Aluno a1) {
		// TODO Auto-generated method stub
		this.garanteEspaco();
		this.aluno[totalAlunos]=a1;
		totalAlunos++;
//		for (int i = 0; i < aluno.length; i++) {
//			if(aluno[i]==null) {
//				aluno[i]=a1;
//				break;
//			}
//		}
	}
}
