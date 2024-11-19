package br.com.pratica.javaOO;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Menu {
	String nome, cpf;
	Scanner scan = new Scanner(System.in);
	List<Pessoa> lista = new ArrayList<Pessoa>();
	List<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
	ValidaCPF validaCpf = new ValidaCPF();
	Pessoa pessoa;
	Integer numId;
	Funcionario funcionario;
	Map<String, Pessoa> mapaPessoa = new HashMap<>();

	public void menu() {
		System.out.println("1-Cadastrar pessoa");
		System.out.println("2-Cadastrar funcionario");
		System.out.println("3-Busca por cpf");
		System.out.println("4-Listar pessoas");
		System.out.println("5-Listar funcionarios");
		System.out.println("6-Filtrar por nome");
		System.out.println("7-Sair");
	}

	public void logicaMenu() {
		int i;

		do {
			this.menu();
			i = scan.nextInt();
			switch (i) {
			case (1):
				cadastrarPessoa();
				break;
			case (2):
				System.out.println("Cadastrar funcionario");
				scan.nextLine();
				System.out.println("Realizar busca de pessoa cadastrada por cpf:");
				cpf = scan.nextLine();
				pessoa = buscaPorCpf(cpf);
				if (pessoa != null) {
					System.out.println("Insira o número de identificação:");
					numId = scan.nextInt();
					funcionario = new Funcionario(pessoa.getNomeDaPessoa(), pessoa.getCpf(), numId);
					listaFuncionario.add(funcionario);
				} else {
					System.out.println("Pessoa não encontrada na lista");
				}
				break;
			case (3):
				System.out.println("Buscar por CPF :");
				scan.nextLine();
				cpf = scan.nextLine();
				pessoa = buscaPorCpf(cpf);
				System.out.println(pessoa);
				break;
			case (4):
				scan.nextLine();
				lista.sort(Comparator.comparing(Pessoa::getNomeDaPessoa));
				lista.forEach(System.out::println);
				break;
			case (5):
				listaFuncionario.sort(Comparator.comparing(Funcionario::getNomeDaPessoa));
				listaFuncionario.forEach(System.out::println);
				break;
			case (6):
				System.out.println("Digite um nome:");
				scan.nextLine();
				String nome_pessoa = scan.nextLine();
				List<Pessoa> listaDePessoa=lista.stream().filter((s)->s.getNomeDaPessoa().equals(nome_pessoa)).toList();
				if(listaDePessoa!=null)
				listaDePessoa.forEach(System.out::println);
				
				break;
			
			case(7):
				break;
			}
		} while (i != 7);
	}

	private Pessoa buscaPorCpf(String cpfDaPessoa) {
		// TODO Auto-generated method stub
		if (!mapaPessoa.containsKey(cpfDaPessoa)) {
			throw new IllegalArgumentException("Não contém pessoa cadastrada com esse cpf");
		}
		return mapaPessoa.get(cpfDaPessoa);

	}

	private void cadastrarPessoa() {
		scan.nextLine();
		System.out.println("\n1-Cadastrar pessoa");

		System.out.println("Digite o nome da pessoa:");
		nome = scan.nextLine();
		scan.nextLine();
		System.out.println("Digite o cpf da pessoa:");
		cpf = scan.nextLine();
		if (validaCpf.isCPF(cpf)) {
			System.out.println("Nome:" + nome + "CPF=" + cpf);
			pessoa = new Pessoa(nome, cpf);
			if (lista.contains(pessoa)) {
				System.out.println("Pessoa já está cadastrada");
			} else {
				System.out.println(lista.contains(pessoa));
				lista.add(pessoa);
				mapaPessoa.put(pessoa.getCpf(), pessoa);
				System.out.println("Pessoa cadastrada com cpf:" + validaCpf.imprimeCPF(cpf));
			}

		} else {
			System.out.println("Cpf inválido!");
		}

	}

}
