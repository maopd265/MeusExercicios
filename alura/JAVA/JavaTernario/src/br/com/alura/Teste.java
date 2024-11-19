package br.com.alura;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int value = (10>100)?2:(10<1)?1:3;
		int valueDois=(1000>100)?(1000>10000)?2:3:(10<100)?1:1231321;
		int valueTres=(1000>100000)?((100000>10000)?2:3):13232;
		System.out.println(value);
		System.out.println(valueDois);
		System.out.println(valueTres);
	}

}
