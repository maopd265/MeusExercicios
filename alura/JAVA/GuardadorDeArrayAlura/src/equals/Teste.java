package equals;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String nomePessoa = "Mauricio";
       String nomePessoaDois="Oiciruam";
       String nomePessoaTres="Mauricio";
       if(nomePessoa.equals(nomePessoaTres)) {
    	   System.out.println("o nomePessoa "+nomePessoa+" é igual ao nomePessoaTres");
    	   
    	   
       }
       if(!nomePessoa.equals(nomePessoaDois)) {
    	   System.out.println("nomePessoa eh diferente de "+nomePessoaDois+" nomePessoaDois");
       }
	}

}
