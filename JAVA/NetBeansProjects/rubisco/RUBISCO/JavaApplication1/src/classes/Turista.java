package classes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AMBegossi, MZB
 */
import java.util.*;
import java.lang.*;
public class Turista extends Usuario{
    private String nome; 
    private int cpf;
    private int numCadTur;
    public Turista() {
    }

    public Turista(int cpf, String usuario, String senha) {
        super(usuario, senha);
        this.cpf = cpf;
        this.nome=nome;
    }

    public Turista(int CPF) {
        this.cpf = cpf;
    }
   public Turista (String nome)
   {
       this.nome=nome;
   }
   public String getNome()
   {
       return nome;
   }
   
   public void setNumCadTur(int num)
   {
       this.numCadTur=numCadTur;
   }
   public int getNumCadTur()
   {
       return numCadTur;
   }
   public void setNome(String nome)
   {
       this.nome=nome;
   }
    public int getCPF() {
        return cpf;
    }
    
    public void setCPF(int CPF) {
        this.cpf = cpf;
    }
    
    @Override
    public String toString(){
        String classe, str;
        classe = this.getClass().getSimpleName();
        return str = super.toString() +"Cpf : "+this.cpf+"\n";
    }

    void setCPF(String cpf2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
