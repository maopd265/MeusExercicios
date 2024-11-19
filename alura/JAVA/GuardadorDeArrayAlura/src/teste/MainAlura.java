package teste;

public class MainAlura {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GuardadorDeArray guardador  = new GuardadorDeArray();
		Conta contaUm = new Conta("abc",123);
		Conta contaDois=new Conta("bca",231);
		guardador.adiciona(contaUm);
		guardador.adiciona(contaDois);
		System.out.println("Quantidade de elementos:"+guardador.getQuantidadeDeElementos());
		System.out.println("Pos 0:"+guardador.getRef(0).getNomeDaPessoa());
		System.out.println("Pos 1:"+guardador.getRef(1).getNomeDaPessoa());
	}

}
