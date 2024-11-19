package classes;

import classes.Atrativo;
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @aut1 hor AMBegossi
 */
public class Servico implements Serializable {

    private String nome;
    private String endereco;
    private String cidade;
    private float preco;
    private Categoria cat;
    private Provedor prov;
    private Atrativo atra;
    private float nota;

    public Servico() {
    }

    public Servico(String nome, String endereco, String cidade, float preco, Atrativo atra) {
        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;
        this.preco = preco;
        this.atra = atra;
        this.cat = null;
        this.prov = null;
        this.nota = 0;
    }

    public void setAtra(Atrativo atra) {
        this.atra = atra;
    }

    public Atrativo getAtra() {
        return atra;
    }

    public void setNota(float nota) {
        if (this.nota == 0) {
            this.nota = nota;
        } else {
            this.nota = (this.nota + nota) / 2;
        }
    }

    public float getNota() {
        return nota;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getNome() {
        return nome;
    }

    public float getPreco() {
        return preco;
    }

    public Categoria getCat() {
        return cat;
    }

    public Provedor getProv() {
        return prov;
    }

    public void setCat(Categoria cat) {
        this.cat = cat;
    }

    public void setProv(Provedor prov) {
        this.prov = prov;
    }

    /*@Override
    public String toString() {
        return "Servico{" + "nome=" + nome + ", endereco=" + endereco + ", cidade=" + cidade + ", preco=" + preco + ", cat=" + cat + ", prov=" + prov + ", atra=" + atra + '}';
    }*/
    @Override
    public String toString() {
        return "Servico{" + "nome=" + nome + ", endereco=" + endereco + ", cidade=" + cidade + ", preco=" + preco + ", cat=" + cat + ", prov=" + prov + ", atra=" + atra + ", nota=" + nota + '}';
    }

    public String toHtml() {
        return "<html>" + "<b>" + nome + "</b> <br />Endereço: " + endereco + "<br /> Cidade: " + cidade + "<br /> Preço: " + preco + "<br /> Categoria: " + cat.getNome() + "<br /> Atrativo: " + atra.getNome() + "<br /> Nota: " + nota + "</html>";
    }

}
