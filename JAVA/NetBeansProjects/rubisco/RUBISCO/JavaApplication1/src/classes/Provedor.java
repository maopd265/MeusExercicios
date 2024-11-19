package classes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AMBegossi
 */
public class Provedor extends Usuario {
    private int cnpj;
    private int numCadProv; 
    public Provedor() {
    }

    public Provedor(int cnpj) {
        this.cnpj = cnpj;
    }

    public Provedor(int cnpj, String usuario, String senha) {
        super(usuario, senha);
        this.cnpj = cnpj;
    }

    
    public int getnumCadProv() {
        return numCadProv;
    }

    public void setnumCadProv(int numCadProv) {
        this.numCadProv = numCadProv;
    }
    
    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }
    
    @Override
    public String toString(){
        String classe, str;
        classe = this.getClass().getSimpleName();
        str = super.toString() +"Cnpj : "+this.cnpj+"\n";
        return str;
    }
    
    
}
