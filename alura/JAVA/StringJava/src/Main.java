import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg = "ola mundo";
		msg=msg.replace("ola", "mundo");
		System.out.println(msg);
		Scanner scan = new Scanner(System.in);
		msg = scan.nextLine();
		msg=msg.replace("ola mundo", "mundo ola");
		System.out.println(msg);
		Thread t1 = new Thread(new ThreadUm());
		t1.start();
	}

}
