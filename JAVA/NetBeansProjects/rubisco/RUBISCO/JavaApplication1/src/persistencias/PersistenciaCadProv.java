package persistencias;


import classes.Provedor;
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
public class PersistenciaCadProv {
    




   
    
    
    

    public void armazenaTurista(ArrayList lista)
    {
        try
        {
            BufferedWriter saida = new BufferedWriter(new FileWriter("CadProv.txt"));
            Provedor aux ;
            for(int i=0 ; i<lista.size() ; i++)
            {
                aux = (Provedor) lista.get(i);
                aux.setnumCadProv(i);
                saida.write(aux.getnumCadProv());
                saida.newLine();
                saida.write(aux.getCnpj());
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
            BufferedReader entrada = new BufferedReader(new FileReader("CadProv.txt"));
            Provedor aux = new Provedor() ;
            int cnpj,num;
            //int idade;
            
            for(int i=0 ; i<lista.size() ; i++ )
            {
                
                cnpj= entrada.read();
                num=entrada.read();
                aux.setCnpj(cnpj);
                aux.setnumCadProv(num);
                lista.add(aux);
                //nome = entrada.readLine();
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

    



