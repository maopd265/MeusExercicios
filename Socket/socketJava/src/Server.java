import java.io.DataInputStream;
import java.io.DataOutputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Server{
    public static void main(String args[])  {

		Livro livroNovo= new Livro();;
		String resultado ;
		int port = 9999;
		String tituloLivro,autorLivro,edicaoLivro,tipo;
		int anoPublicacaoLivro;
		ServerSocket ss = null;
		 
		System.out.println("Server");
		try{
			ss = new ServerSocket(port); //criar server Socket
			while(true){
				System.out.println("Aguardando...");
            Socket s1 = ss.accept();  //
			
			InputStream is = s1.getInputStream();
			OutputStream os1 = s1.getOutputStream();
			DataOutputStream dos1 = new DataOutputStream(os1);
			DataInputStream dis = new DataInputStream(is);
			

			BancoDeDados bd = new BancoDeDados();
				 





			System.out.println("Esperando o tipo de operação...");
			tipo = dis.readUTF();
			
			if(tipo.equals("1")){

				
				tituloLivro=dis.readUTF();
				System.out.println("Titulo do livro:"+tituloLivro);
				
				autorLivro=dis.readUTF();
				System.out.println("Autor do livro:"+autorLivro);
				
				edicaoLivro = dis.readUTF();
				System.out.println("Edição livro:"+edicaoLivro);
				
				anoPublicacaoLivro= Integer.parseInt(dis.readUTF());
				System.out.println("Ano de publicação:"+anoPublicacaoLivro);
				 
				
				
				livroNovo.setTituloLivro(tituloLivro);
				livroNovo.setAutorLivro(autorLivro);
				livroNovo.setEdicaoLivro(edicaoLivro);
				livroNovo.setAnoPublicacao(anoPublicacaoLivro);
				 


				 if(bd.VerificarExistencia(livroNovo))
				 {
					resultado="Existe na base de dados!";
				 }
				 else
				 {
					resultado="Cadastrado com sucesso!";
				 }
				
					
			 
				
				
			     
				 
				 
				
				
				dos1.writeUTF(resultado);
				
			}
			else if (tipo.equals("2")) {
				System.out.println("Consulta...");
				tituloLivro=dis.readUTF();
				System.out.println("Titulo do livro:"+tituloLivro);
				
				autorLivro=dis.readUTF();
				System.out.println("Autor do livro:"+autorLivro);
				
			}
			else if (tipo.equals("3")) {
				//resultado = x * y;
			}
			else if (tipo.equals("4")) {
				//resultado = x / y;
			}
			else if (tipo.equals("5")) {
				//resultado = x / y;
			}
			else{
				System.out.print("Error");
			}

			//System.out.println("O resultado é: "+resultado);
           // System.out.println(" ");
			//dos1.writeUTF(Integer.toString(resultado));
			
			s1.close();
			dis.close();
			dos1.close();
        }	
		}
		catch(IOException e){
			System.out.println("ERROR NO CLIENTE");	
		}
		 
    
	}
	
}