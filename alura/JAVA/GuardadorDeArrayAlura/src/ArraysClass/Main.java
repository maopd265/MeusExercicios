package ArraysClass;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-------------------------------------------");
		 int[] numeros={5, 4, 0, -13, 2112, 14, 1};
		 Arrays.sort(numeros,0,2);
        for(int i=0;i<numeros.length;i++) 
        {
       	 System.out.println(numeros[i]);
        }
//        System.out.println("Array ordenado: "+Arrays.toString(numeros));
	}

}
