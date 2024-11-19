
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double num = 8.2;
		String numString = "8.2";
		int numero;
		numero=(int) num;
		System.out.println("(int)num ="+numero);
		numero=(int)Double.parseDouble(numString);
		System.out.println("(int)Double.parseDouble(numString):"+numero);
		double numeral = Double.valueOf(numString);
		System.out.println("Double.valueOf(numString):"+numeral);
		
		
	}

}
