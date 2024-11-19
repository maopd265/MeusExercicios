package WrapersInteger;
import java.util.ArrayList;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList array = new ArrayList();
		array.add(3);
		array.add(1);
		array.add(2);
		for (Object object : array) {
			System.out.println(object.toString());
		}
		array.sort(null);
		for (Object object : array) {
			System.out.println(object.toString());
		}
	}

}
