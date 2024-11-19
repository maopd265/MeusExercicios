package br.com.alura;

	import java.util.Comparator;

	public class Conta implements Comparator<Conta>{
		
		private String nomeDaPessoa;
		private int numero;

		public Conta() {
			// TODO Auto-generated constructor stub
		}
		public Conta(String nomeDaPessoa,int numero) {
			// TODO Auto-generated constructor stub
			this.nomeDaPessoa=nomeDaPessoa;
			this.numero=numero;
		}
		public String getNomeDaPessoa() {
			return nomeDaPessoa;
		}

		public void setNomeDaPessoa(String nomeDaPessoa) {
			this.nomeDaPessoa = nomeDaPessoa;
		}
		
		public int getNumero() {
			return numero;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "nome da pessoa eh "+this.getNomeDaPessoa()+", número da conta é: "+this.getNumero();
		}
		@Override
		public int compare(Conta conta, Conta outraConta) {
	        if(conta.getNomeDaPessoa().compareTo(outraConta.getNomeDaPessoa())==0) {
//	        	if(conta.getNumero()<outraConta.getNumero()) {
//	        		return -1;
//	        	}else if(conta.getNumero()>outraConta.getNumero()) {
//	        		return 1;
//	        	} 
	        	return Integer.compare(conta.getNumero(), outraConta.getNumero());
	        	
	        	
	        }
			
	        return conta.getNomeDaPessoa().
	                compareTo(outraConta.getNomeDaPessoa());
	    }
		
		 @Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			 Conta count = (Conta) obj;
			if(this.getNomeDaPessoa()!=count.getNomeDaPessoa()) {
				return false;
			}
			if(this.getNumero()!=count.getNumero()) {
				return false;
			}
			return true;
			 
		}
		 
	}


