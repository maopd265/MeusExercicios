/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Bavaresco
 */
public class Usuario {
    private String login;
    private String nome;
    private String senha;
   public Usuario()
    {
        this.login=login;
        this.senha=senha;
        this.nome=nome;
    }
   public Usuario(String login,String senha,String nome)
    {
        this.login=login;
        this.senha=senha;
        this.nome=nome;
    }

    /**
     * salvar no txt
     */
    public String salvarTxt() throws IOException
    {
        FileWriter fw = new FileWriter("cadastro.txt",true);
        PrintWriter pw= new PrintWriter(fw);
        pw.println(this.nome+","+this.login+","+this.senha);
        
        pw.flush();
        pw.close();
        fw.close();
        return null;
        
    }
  

	public static void leitor() throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader("cadastro.txt"));
		String linha = "";
		while (true) {
			if (linha != null) {
				System.out.println(linha);

			} else
				break;
			linha = buffRead.readLine();
		}
		buffRead.close();
	}
    
}
