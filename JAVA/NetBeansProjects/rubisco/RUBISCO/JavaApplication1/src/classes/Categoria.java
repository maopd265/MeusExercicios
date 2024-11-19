package classes;

import java.io.Serializable;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AMBegossi
 */
public class Categoria implements Serializable {
    private String nome;
    private ArrayList<Servico> listaServicos = new ArrayList();

    public Categoria() {
    }

    public Categoria(String nome) {
        this.nome = nome;
    }
 
    public void incluirServico(Servico ser){
        listaServicos.add(ser);
    }
    
    public int getTamanhoListaServicos(){
        return listaServicos.size();
    }
    
    public Servico getServico(int i){
        return listaServicos.get(i);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Categoria{" + "nome=" + nome + '}';
    }

    
}



