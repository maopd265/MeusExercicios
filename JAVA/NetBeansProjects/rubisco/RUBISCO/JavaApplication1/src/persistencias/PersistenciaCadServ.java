package persistencias;


import classes.Servico;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.*;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MZB
 */
public class PersistenciaCadServ 
{
    public void armazenaServico(ArrayList lista)
    {
        try
        {
            BufferedWriter saida = new BufferedWriter(new FileWriter("CadTurista.txt"));
            Servico aux ;
            for(int i=0 ; i<lista.size() ; i++)
            {
                aux = (Servico) lista.get(i);
                //aux.setNumServ(i);
                //saida.write(aux.getNum());
                saida.newLine();
                saida.write(aux.getNome());
                saida.newLine();
                saida.write(aux.getEndereco());
                saida.newLine();
                saida.write((int) aux.getPreco());
                saida.newLine();
                saida.write( aux.getCidade());
                saida.newLine();
            }
            saida.flush();
            saida.close();
        }        
        catch(IOException e)
        {
        }
    }

    public ArrayList recuperaServico()
    {
        ArrayList lista = new ArrayList(100);
        try
        {
            BufferedReader entrada = new BufferedReader(new FileReader("CadTurista.txt"));
            Servico aux = new Servico() ;
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
