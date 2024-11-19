package WrapersInteger;
import java.util.ArrayList;
import java.util.List;
public class NumberMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Integer inteiro= Integer.valueOf(10);
		  System.out.println(inteiro.doubleValue());
		  Double varDouble = Double.valueOf(123.123);
		  System.out.println(varDouble.intValue());
		  
		  
		  
		  
		  
		  
		  
		  
		  //Unboxing
		  
		  Integer newIntegerNumber =Integer.valueOf(-200);
		  int absValue = absoluteValue(newIntegerNumber);
		  System.out.println("ABSVALUE:"+absValue);
		  methodWide(absValue);
		  methodWide(newIntegerNumber);
		  
		  
		  
		  
		  
		  
		  //Autoboxing
		  Integer numInteiro = 10;
		  //Unboxing
//		  int num = new Integer(12);
		  int num = Integer.valueOf(12);
		  System.out.println("numInteiro:"+numInteiro+" , num:"+num);
		  ArrayList<Integer> array = new ArrayList<Integer>();
		  array.add(numInteiro);
		  array.add(num);
		  int resultadoSoma =sumEvenNumbers(array);
		  System.out.println(resultadoSoma);
	}
	private static int absoluteValue(Integer newIntegerNumber) {
		// TODO Auto-generated method stub
		
		return (newIntegerNumber<0) ? -newIntegerNumber:newIntegerNumber;
	}
	//Método Autoboxing
	public static int sumEvenNumbers(List<Integer> intList ) {
	    int sum = 0;
	    for (Integer i: intList )
	        if ( i % 2 == 0 )
	            sum += i;
	        return sum;
	}
	static void methodWide(int i) {
        System.out.println("int");
    }

    static void methodWide( Integer i ) {
        System.out.println("Integer");
    }
	
}
