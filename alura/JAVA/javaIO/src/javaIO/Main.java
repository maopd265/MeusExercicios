package javaIO;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

import br.com.alura.Conta;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("example.txt");
		ArrayList<Conta> countList = new ArrayList<Conta>();
		 String line;
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			line = br.readLine();
			String textLine[];
			while(line!=null) 
			{
				System.out.println(line);
				textLine=line.split(",");
				Conta count = new Conta(textLine[0],Integer.parseInt(textLine[1]));
				countList.add(count);
				line = br.readLine();
			}
			Collections.sort(countList,new Conta());
			zerarArquivo(file);
			
			FileWriter fwTwo = new FileWriter(file,true);
			BufferedWriter bw = new BufferedWriter(fwTwo);
			for (Conta conta : countList) {
				bw.write(conta.getNomeDaPessoa());
				bw.write(",");
				
				bw.write(Integer.toString(conta.getNumero()));
				bw.newLine();
				
			}
			
			bw.close();
			fwTwo.close();
			
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		 
		
		 

	}
	public static void zerarArquivo(File file) 
	{
		
		try {
			FileWriter fwOne = new FileWriter(file,false);
			fwOne.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}