package testeJavaUtil;

import java.text.ParseException;

public class Main {
public static void main(String[] args) {
	Conta conta[] = new Conta[2];
	for(int i=0;i<conta.length;i++) 
	{
		Conta contaPessoal = new Conta();
		if(i==0) {
			contaPessoal.setNomeDaPessoa("Ola mundo");
		}else {
			contaPessoal.setNomeDaPessoa("Mundo ola");
		}
		
		conta[i]=contaPessoal;
		//System.out.println(conta[i].getNomeDaPessoa());
	}
	for(int i=0;i<conta.length;i++) 
	{
		
		System.out.println(conta[i].toString());
	}
}
}
