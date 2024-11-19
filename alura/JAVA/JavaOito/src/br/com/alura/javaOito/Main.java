package br.com.alura.javaOito;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class Main {

	public static String toUpperInicio(String teste) {
		 String posicao= ""+teste.charAt(0);
		 String mais="";
		    String pos=posicao.toUpperCase();
		    String todaString=pos;
		    int tamanho=teste.length();
		    for(int i=1;i<teste.length();i++){
		        mais=mais+teste.charAt(i);
		    }
		    todaString=pos+mais;
		    return todaString;
		 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> lista = new ArrayList<String>();
		lista.add("asd");
		lista.add("Ola mundo");
		lista.add("Alo mundo");
		//Comparator<String> comparador = new ComparadorPorTamanho();
		for (int i=0;i<lista.size();i++) {
			lista.set(i, toUpperInicio(lista.get(i)));
			System.out.println(lista.get(i)); 
			
		}
		 lista.forEach(palavra->{
			 palavra=toUpperInicio(palavra);
			 System.out.println(toUpperInicio(palavra));
		 });
//		lista.sort(new Comparator<String>() {
//
//			@Override
//			public int compare(String o1, String o2) {
//				// TODO Auto-generated method stub
//				return o1.compareTo(o2);
//			}
//			
//		});
		//lista.sort((String o1, String o2)->  o1.compareTo(o2));
		//lista.sort(Comparator.comparing( s -> s.length()));
		// lista.sort(Comparator.comparing(String::length));
		 System.out.println(lista);
		 String teste = "teste";
		 
		 lista.sort(String.CASE_INSENSITIVE_ORDER);
		 
		 
		 
		 lista.forEach(System.out::println);
		 
//		 lista.forEach((elemento)->{
//			 System.out.println(elemento); 
//		 });
//		lista.forEach(new Consumer<String>() {
//
//			@Override
//			public void accept(String t) {
//				// TODO Auto-generated method stub
//				System.out.println(t);
//				
//			}
//		
//		});
		
	}

}

class ComparadorPorTamanho implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return o1.compareTo(o2);
	}
	
}
//class ImprimeNaLinha implements Consumer<String>{
//
//	@Override
//	public void accept(String t) {
//		// TODO Auto-generated method stub
//		System.out.println(t);
//		
//	}
//	
//}
