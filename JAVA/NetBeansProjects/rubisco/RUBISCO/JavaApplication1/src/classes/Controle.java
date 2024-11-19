/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author USER_IURI
 */
public class Controle {
    private int loginturista;// flags de controle para saber se o ususrio esta logado
    private int loginprovedor;
    
    public Controle(){
        this.loginprovedor = 0;
        this.loginturista = 0; 
        
    }
    
    public void setturista(int loginturista) {
        this.loginturista = loginturista;
    }

    public int getturista() {
        return loginturista;
    }
    public void setprovedor(int loginprovedor) {
        this.loginprovedor = loginprovedor;
    }

    public int getprovedor() {
        return loginprovedor;
    }

}
