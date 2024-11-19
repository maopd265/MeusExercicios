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
 * @author Anderson
 */
public class Atrativo implements Serializable {
    private String nome;
    private String cidade;
    private ArrayList<Servico> listaServicos = new ArrayList();
    
    public Atrativo (){    
    }

    public Atrativo(String nome, String cidade) {
        this.nome = nome;
        this.cidade = cidade;
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

    public String getCidade() {
        return cidade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Atrativo{" + "nome=" + nome + ", cidade=" + cidade + '}';
    }

    public Object toHtml() {
        return "<html><b>" + nome + "</b> <br />Cidade:" + cidade + "</html>";
    }
            
            
}
