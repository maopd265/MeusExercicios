
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.io.OutputStream;
import java.net.Socket;

import javax.net.SocketFactory;


public class Client {
    public static void main(String args[]){

		String cad1,cad3;
		String resultado = "";
		String url = "localhost";
		int port = 9999;

		SocketFactory socketFactory = SocketFactory.getDefault();
		try{
			// Socket sc1 = new Socket(url, port);
			Socket sc1 = socketFactory.createSocket(url,port);
			InputStreamReader isr = new InputStreamReader( System.in );
			InputStream is = sc1.getInputStream();
			BufferedReader bf = new BufferedReader(isr);	
			OutputStream os1 = sc1.getOutputStream();
			DataOutputStream dos1 = new DataOutputStream(os1);
			DataInputStream dis = new DataInputStream(is);

			
			

			System.out.println("Que tipo de operação :");
			System.out.println("1)Criar livro \n2)Consultar livro\n3)Consultar por ano e número da edição \n4)Remover livro \n5)Alteração do Livro");
			cad3 = bf.readLine();
			int opcao = Integer.parseInt(cad3);
			

			System.out.println("cad3="+cad3);
			
			switch (opcao) {
				
				case 1:
				dos1.writeUTF(cad3);
				System.out.println("1)Criar livro ");
				
				
				System.out.println("Digite um titulo do livro para o servidor: ");
				
				cad1 = bf.readLine();
				dos1.writeUTF(cad1);

				System.out.println("Digite um Autor do livro para o servidor: ");
				cad1 = bf.readLine();
				dos1.writeUTF(cad1);
 
				System.out.println("Digite a Edição do livro para o servidor: ");
				cad1 = bf.readLine();
				dos1.writeUTF(cad1);

				System.out.println("Digite ano de publicação do livro para o servidor: ");
				cad1 = bf.readLine();
				dos1.writeUTF(cad1);
				// System.out.println("Digite o código do livro para o servidor: ");
				// cad1 = bf.readLine();
				//dos1.writeUTF(cad1);


				resultado = dis.readUTF();
				System.out.println("  " + resultado);


				 
				
				dos1.flush();	
				
				dos1.close();
				
				
				break;
			


				case 2:

				System.out.println("2)Consultar livro");
				//nome do autor (completo e parcial) e pelo título do livro
				dos1.writeUTF(cad3);
				System.out.println("Digite um titulo do livro para o servidor: ");
				
				cad1 = bf.readLine();
				dos1.writeUTF(cad1);

				System.out.println("Digite um Autor do livro para o servidor: ");
				cad1 = bf.readLine();
				dos1.writeUTF(cad1);
				dos1.flush();	
				
				dos1.close();
				break;       


				case 3:

				System.out.println("3)Consultar por ano e número da edição ");


				 break;

				case 4:
				System.out.println("4)Remover livro"); 

				break;

				case 5:

				System.out.println("5)Alteração do Livro");
				break;
			
				default:
					break;
			}
			
			
			
			
			
			
			// dos1.writeUTF(cad3);

			

			
		sc1.close();




		 
            
		}
		catch(IOException e){	
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("Ocorreu IOException!");
		}
		
	}	       
}