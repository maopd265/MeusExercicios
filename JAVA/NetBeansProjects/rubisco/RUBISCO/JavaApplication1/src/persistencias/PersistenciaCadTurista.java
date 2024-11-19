package persistencias;


import classes.Turista;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
   

/**
 *
 * @author Mauricio ZB
 * *** Gravar usuario e senha no txt
 */

public class PersistenciaCadTurista 
{
   
    
    
    

    public void armazenaTurista(ArrayList lista)
    {
        try
        {
            BufferedWriter saida = new BufferedWriter(new FileWriter("CadTurista.txt"));
            Turista aux ;
            for(int i=0 ; i<lista.size() ; i++)
            {
                aux = (Turista) lista.get(i);
                aux.setNumCadTur(i);
                saida.write(aux.getNumCadTur());
                saida.newLine();
                saida.write(aux.getNome());
                saida.newLine();
                saida.write(aux.getCPF());
                saida.newLine();
                
            }
            saida.flush();
            saida.close();
        }        
        catch(IOException e)
        {
        }
    }

    public ArrayList recuperaTurista()
    {
        ArrayList lista = new ArrayList(100);
        try
        {
            BufferedReader entrada = new BufferedReader(new FileReader("CadTurista.txt"));
            Turista aux = new Turista() ;
            String nome2,cpf2;
            //int idade;
            String nome = entrada.readLine();
            while(nome!=null)
            {
                nome2= entrada.readLine();
                cpf2= entrada.readLine();
                
                aux.setNome(nome2);
//                aux.setCPF(cpf2);
                lista.add(aux);
                nome = entrada.readLine();
            }
            entrada.close();
        }        
        catch(IOException e)
        {
            System.out.println("erro de io");
        }
        
        return lista;
    }
}

    

