package ClassesAnonimas;
import java.util.ArrayList;
import java.util.Comparator;

import teste.Conta;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ArrayList<Conta> countList = new ArrayList<Conta>();
        ArrayList<String> stringList = new ArrayList<String>();
        Comparator<String> comp = new Comparator<String>() {

      	  @Override
      	  public int compare(String s1, String s2) {
      	    return s1.compareTo(s2);
      	  }
      	};
        stringList.add("aasdd");
        stringList.add("casdd");
        stringList.add("basdd");
        stringList.add("dasdd");
        stringList.add("easdd");
        stringList.sort(comp);	
        for (String stringElement : stringList) {
			System.out.println(stringElement);
		}
        
        System.out.println("---------------------------------");
        System.out.println("Contas");
        countList.add(new Conta("ooadsi",545));
        countList.add(new Conta("boadsi",345));
        countList.add(new Conta("aoadsi",245));
        countList.add(new Conta("aoadsi",145));
        countList.add(new Conta("coadsi",145));
        countList.sort(new Comparator<Conta>(){

        	@Override
        	public int compare(Conta conta, Conta outraConta) {
                if(conta.getNomeDaPessoa().compareTo(outraConta.getNomeDaPessoa())==0) {
//                	if(conta.getNumero()<outraConta.getNumero()) {
//                		return -1;
//                	}else if(conta.getNumero()>outraConta.getNumero()) {
//                		return 1;
//                	} 
                	return Integer.compare(conta.getNumero(), outraConta.getNumero());
                	
                	
                }
                return conta.getNomeDaPessoa().
                        compareTo(outraConta.getNomeDaPessoa());
        	
        }
        }
        );
        
        
        for (Conta count : countList) {
			System.out.println(count);
		}
        		
        		
	}

}
