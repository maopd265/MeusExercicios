package javautilAlura;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("teste");
//		int array[] = new int[1];
//		int[] arrayDois = new int[1];
//		array[0]=arrayDois[0]=100;
//		System.out.println("Array------"+array[0]+" "+arrayDois[0]);
//		System.out.println("Tamanho array:"+array.length);
//		System.out.println(Math.pow(2, 3));
		System.out.println("ARRAY CLASSE CONTACORRENTE");
		ContaCorrente conta[]= new ContaCorrente[2];
		ContaCorrente contaUm = new ContaCorrente();
		contaUm.setNomePessoa("ola mundo");
		contaUm.setId("123");
		ContaCorrente contaDois = new ContaCorrente();
		contaDois.setNomePessoa("ola mundo");
		contaDois.setId("123");
		conta[0]=contaUm;
		conta[1]=contaDois;
		//System.out.println(conta[0].getNomePessoa()+" "+conta[1].getNomePessoa());
		for (ContaCorrente contaCorrente : conta) {
			System.out.println(contaCorrente.getNomePessoa());
		}
	}

}
