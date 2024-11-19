package WrapersInteger;
import java.util.ArrayList;
import java.util.Arrays;
public class MainInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer numero = Integer.valueOf(2);
		Integer numeroDois=Integer.valueOf(10);
		Integer numeroTres=Integer.valueOf(1);
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(numero);
		array.add(numeroDois);
		array.add(numeroTres);
		array.add(numero);
		array.add(numero);
		for (Integer integer : array) {
			System.out.println(integer.toString());
		}
		System.out.println("-------------------------------------------");
		array.sort(null);
		for (Integer integer : array) {
			System.out.println(integer.toString());
		}
		
	}

}
