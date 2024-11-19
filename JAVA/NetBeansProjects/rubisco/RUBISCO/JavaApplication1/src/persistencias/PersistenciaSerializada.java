package persistencias;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import classes.Usuario;
import classes.Servico;
import classes.Atrativo;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
 
/**
 *
 * @author vinic
 */
public class PersistenciaSerializada {

 
    public PersistenciaSerializada() {    }
 
    public void serializarListUsuarios(String arquivo, ArrayList<Usuario> lu) throws Exception {
        try{
            FileOutputStream outFile = new FileOutputStream(arquivo);
            ObjectOutputStream s = new ObjectOutputStream(outFile);
            s.writeObject(lu);
            outFile.close();
            s.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void serializarListServico(String arquivo, ArrayList<Servico> ls) throws Exception {
        try{
            FileOutputStream outFile = new FileOutputStream(arquivo);
            ObjectOutputStream s = new ObjectOutputStream(outFile);
            s.writeObject(ls);
            outFile.close();
            s.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void serializarListAtrativo(String arquivo, ArrayList<Atrativo> la) throws Exception {
        try{
            FileOutputStream outFile = new FileOutputStream(arquivo);
            ObjectOutputStream s = new ObjectOutputStream(outFile);
            s.writeObject(la);
            outFile.close();
            s.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public ArrayList<Usuario> deserializarListUsuario(String arquivo) throws Exception {
        FileInputStream inFile = null;
        ArrayList<Usuario> list = new ArrayList<Usuario>();
        try {
            inFile = new FileInputStream(arquivo);
            ObjectInputStream d = new ObjectInputStream(inFile);
            list = (ArrayList<Usuario>) d.readObject();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<Servico> deserializarListServico(String arquivo) throws Exception {
        FileInputStream inFile = null;
        ArrayList<Servico> list = new ArrayList<Servico>();
        try {
            inFile = new FileInputStream(arquivo);
            ObjectInputStream d = new ObjectInputStream(inFile);
            list = (ArrayList<Servico>) d.readObject();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<Atrativo> deserializarListAtrativo(String arquivo) throws Exception {
        FileInputStream inFile = null;
        ArrayList<Atrativo> list = new ArrayList<Atrativo>();
        try {
            inFile = new FileInputStream(arquivo);
            ObjectInputStream d = new ObjectInputStream(inFile);
            list = (ArrayList<Atrativo>) d.readObject();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        return list;
    }
    

}

