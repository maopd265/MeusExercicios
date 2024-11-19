import java.util.ArrayList;


import java.util.Collections;
import java.util.List;

import Model.Pessoa;

public class App {
    
    public static void main(String[] args) throws Exception {
         List<Pessoa> array = new ArrayList<>();
        //  ArrayList arraList = new ArrayList();
         
        Pessoa pessoaUm = new Pessoa("A","C");
        Pessoa pessoaDois = new Pessoa("B","B");
        Pessoa pessoaTres = new Pessoa("C","A");
        Pessoa pessoaQuatro = new Pessoa("B","A");
        array.add(pessoaUm);
        array.add(pessoaDois);
        array.add(pessoaTres);
        array.add(pessoaQuatro);
        Collections.sort(array);
        for(Pessoa pessoa : array)
        {
            System.out.println("Nome:"+pessoa.getNome());
            System.out.println("Cidade:"+pessoa.getCidade());
        }
        
    }
}
