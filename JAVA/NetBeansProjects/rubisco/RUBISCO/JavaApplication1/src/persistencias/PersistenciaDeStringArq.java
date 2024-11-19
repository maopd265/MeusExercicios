//package persistencias;
//
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
///**
// *
// * @author User
// */
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
///**
// *
// * @author Mauricio ZB
// * *** Gravar usuario e senha no txt
// */
//
//import classes.Usuario;
//import java.io.*;
//import java.util.*;
//public class PersistenciaDeStringArq
//{
//
//    public void armazenaUsuarios(ArrayList lista)
//    {
//        try
//        {
//            BufferedWriter saida = new BufferedWriter(new FileWriter("Usuarios.txt"));
//            Usuario aux ;
//            for(int i=0 ; i<lista.size() ; i++)
//            {
//                aux = (Usuario) lista.get(i);
//                saida.write(aux.getUsuario());
//                saida.newLine();
//                saida.write(aux.getSenha());
//                saida.newLine();
//                
//            }
//            saida.flush();
//            saida.close();
//        }        
//        catch(IOException e)
//        {
//        }
//    }
//
//    public ArrayList recuperaUsuarios()
//    {
//        ArrayList lista = new ArrayList(100);
//        try
//        {
//            BufferedReader entrada = new BufferedReader(new FileReader("Usuarios.txt"));
//            Usuario aux = new Usuario() ;
//            String usuario,senha;
//            //int idade;
//            String nome = entrada.readLine();
//            while(nome!=null)
//            {
//                usuario= entrada.readLine();
//                senha= entrada.readLine();
//                
//                aux.setUsuario(usuario);
//                aux.setSenha(senha);
//                lista.add(aux);
//                nome = entrada.readLine();
//            }
//            entrada.close();
//        }        
//        catch(IOException e)
//        {
//            System.out.println("erro de io");
//        }
//        
//        return lista;
//    }
//}
