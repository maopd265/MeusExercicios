package classes;


import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author AMBegossi
 */
public class Usuario implements Serializable
{
    protected String usuario;
    protected String senha;

    protected Usuario() {
    }

    protected Usuario(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public String getUsuario() {
        return usuario;
    }

    protected void setSenha(String senha) {
        this.senha = senha;
    }

    protected void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    //ToString função para escrever
    @Override
    public String toString() {
        String classe, str;
        classe = this.getClass().getSimpleName();
        str = "Classe : "+classe+"\n"+"Nome : "+this.usuario+"\n"+"Senha : "+this.senha+"\n";
        return str;
    }
}
