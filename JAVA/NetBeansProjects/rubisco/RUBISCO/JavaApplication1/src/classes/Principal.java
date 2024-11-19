package classes;
import Interface.*;
import java.util.ArrayList;
import java.util.Scanner;
import persistencias.PersistenciaSerializada;

import classes.Usuario;
import classes.Turista;
import classes.Provedor;
import classes.Servico;
import classes.Atrativo;
import Interface.Login;
import Interface.CadastroServico;
import java.io.Serializable;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author VACPotrich
 */


public class Principal {
  
    
    public static void main(String arg[]){
        //InterfaceDoUsuario idu = new InterfaceDoUsuario();
        //idu.menu();
        Menu m = new Menu();
        m.setVisible(true);
    }
}
