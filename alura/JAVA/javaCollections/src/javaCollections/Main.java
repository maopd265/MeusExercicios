package javaCollections;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String texto_um = "Bca";
		String texto_dois = "Cca";
		String texto_tres = "Aca";

		ArrayList<String> array = new ArrayList<String>();
		array.add(texto_um);
		array.add(texto_dois);
		array.add(texto_tres);
		array.forEach((texto) -> System.out.println(texto));
		array.sort(null);
		Collections.reverse(array);

		System.out.println("------------------------------");
		array.forEach((texto) -> System.out.println(texto));
	}

}
