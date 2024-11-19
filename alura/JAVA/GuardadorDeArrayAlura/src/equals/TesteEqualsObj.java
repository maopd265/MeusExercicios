package equals;
import teste.*;
public class TesteEqualsObj {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Conta conta = new Conta("abc",123);
		Conta contaDois = new Conta("abc",123);
		if(!conta.equals(contaDois)) {
			System.out.println("Contas diferentes");
		}else 
		{
			System.out.println("Contas iguais");
		}
	}

}
