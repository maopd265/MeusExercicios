package classes;


import persistencias.PersistenciaSerializada;
import classes.Usuario;
import classes.Turista;
import classes.Provedor;
import classes.Servico;
import classes.Atrativo;
import Interface.Login;
import Interface.CadastroServico;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author VACPotrich
 */
public class InterfaceDoUsuario{
    private ArrayList<Usuario> listaUsuario = new ArrayList();
    private ArrayList<Usuario> listaProvedor = new ArrayList();
    private ArrayList<Servico> listaServicos = new ArrayList();
    private ArrayList<Atrativo> listaAtrativos = new ArrayList();
    private ArrayList<Categoria> listaCategorias = new ArrayList();
    private PersistenciaSerializada ps = new PersistenciaSerializada();
    private Usuario usu;
    private Servico ser;
    private Atrativo atra;
    private Categoria cat;
    private int opcao;
    private  Scanner ler = new Scanner(System.in);
    
    public InterfaceDoUsuario(){
    }
    
    //Interface TEMPORARIA
    public void menu(){
        //variaveis para usuario
        String nome;
        String senha;
        //variaveis para turista
        int cpf;
        //variaveis para provedor
        int cnpj;
        //variaveis para serviços
        String nomeatrativo;
        String nomecategoria;
        //private String nome; ja esta declarada uma deixei para melhor compreensao
        String endereco;
        String cidade;
        float preco;
        do{
            switch(opcao){
                case 1: 
                    System.out.println("1- Inserir Usuario Turista\n");
                    System.out.println("Nome do Turista\n");
                    nome = ler.next();
                    System.out.println("senha do Turista\n");
                    senha = ler.next();
                    System.out.println("Cpf\n");
                    cpf = ler.nextInt();
                    usu = new Turista(cpf,nome,senha);
                    listaUsuario.add(usu);//adicionando no fim da lista por enquanto
                    break;
                case 2:
                    System.out.println("2- Inserir Usuario Provedor\n");
                    System.out.println("Nome do Provedor\n");
                    nome = ler.next();
                    System.out.println("senha do Provedor\n");
                    senha = ler.next();
                    System.out.println("cnpj\n");
                    cnpj = ler.nextInt();
                    
                    usu = new Provedor(cnpj,nome,senha);
                    listaProvedor.add(usu);//adicionando no fim da lista por enquanto
                    
                    break;
                case 3:            
                    System.out.println("3- Cadastrar Serviço\n");
                    System.out.println("Nome do Servico\n");
                    nome = ler.next();
                    System.out.println("Endereco\n");
                    endereco = ler.next();
                    ler.next();
                    System.out.println("cidade\n");
                    cidade = ler.next();
                    System.out.println("preco\n");
                    preco = ler.nextFloat();
                    System.out.println("Atrativo");
                    nomeatrativo = ler.next();
                    System.out.println("Categoria");
                    nomecategoria = ler.next();
                                      
                    // verifica se atrativo ja existe na lista
                    // se ja existe, passa a referencia para o objeto servico
                    int flag=0;
                    for(int i=0; i<listaAtrativos.size(); i++){
                        if (listaAtrativos.get(i).getNome().equals(nomeatrativo)){
                            ser = new Servico(nome,endereco,cidade,preco,listaAtrativos.get(i));  
                            listaAtrativos.get(i).incluirServico(ser);
                            flag=1;
                            break;
                        }
                    }
                    // caso o atrativo nao exista na lista
                    // cria novo atrativo, adiciona na lista, e passa a referencia
                    // para o objeto servico
                    if (flag==0){
                        atra = new Atrativo(nomeatrativo,cidade);
                        listaAtrativos.add(atra);
                        ser = new Servico(nome,endereco,cidade,preco,atra);
                        atra.incluirServico(ser);
                    }
                    
                    // verifica se categoria já existe na lista
                    // se ja existe, seta a categoria no objeto servico
                    flag=0;
                    for(int i=0; i<listaCategorias.size(); i++){
                        if (listaCategorias.get(i).getNome().equals(nomecategoria)){
                            ser.setCat(listaCategorias.get(i));  
                            listaCategorias.get(i).incluirServico(ser);
                            flag=1;
                            break;
                        }
                    }
                    // caso a categoria nao exista na lista
                    // cria nova categoria, adiciona na lista, e seta 
                    // a categoria no objeto servico
                    if (flag==0){
                        cat = new Categoria(nomecategoria);
                        ser.setCat(cat);
                        cat.incluirServico(ser);
                        listaCategorias.add(cat);
                    }                                 
                    
                    // adiciona o novo servico na lista
                    listaServicos.add(ser);//adicionando no fim da lista por enquanto
                    
                    break;
                case 4:
                    System.out.println("4- Escrever Lista de Turistas\n");
                    for(int i=0; i<listaUsuario.size(); i++){
                        System.out.println(listaUsuario.get(i).toString());
                    }
                    break;
                case 5:
                    System.out.println("5- Escrever Lista de Provedores\n");
                    for(int i=0; i<listaProvedor.size(); i++){
                        System.out.println(listaProvedor.get(i).toString());
                    }
                    break;
                case 6:
                    System.out.println("6- Escrever Lista de Serviços\n");
                    for(int i=0; i<listaServicos.size(); i++){
                        System.out.println( listaServicos.get(i).toString());
                    }
                    break;
                case 7:
                    System.out.println("7- Escrever Lista de Atrativos\n");
                    for(int i=0; i<listaAtrativos.size(); i++){
                        System.out.println( listaAtrativos.get(i).toString());
                    }
                    break;
                case 8:
                    System.out.println("8- Escrever serviços de cada atrativo\n");
                    for(int i=0; i<listaAtrativos.size(); i++){
                        System.out.println(listaAtrativos.get(i).getNome());
                        for(int j=0; j<listaAtrativos.get(i).getTamanhoListaServicos(); j++){
                            System.out.println("Serviço : "+listaAtrativos.get(i).getServico(j).getNome());
                        }
                    }
                    break;
                case 9:
                    System.out.println("9- Salva Serializado\n");
                    //serializa
                    try {
                        ps.serializarListUsuarios("ListUsuario", listaUsuario);
                        ps.serializarListUsuarios("ListProvedor", listaProvedor);
                        ps.serializarListServico("ListServico", listaServicos);
                        ps.serializarListAtrativo("ListAtrativo", listaAtrativos);
                    } 
                    catch (Exception ex) {
                        System.err.println("Falha ao serializar! - " + ex.toString());
                    }
                    break;
                case 10:
                    System.out.println("10- Recupera Serializado\n");
                    //deserializa
                    try {
                        listaUsuario = (ArrayList<Usuario>) ps.deserializarListUsuario("ListUsuario");
                        listaProvedor = (ArrayList<Usuario>) ps.deserializarListUsuario("ListProvedor");
                        listaServicos = (ArrayList<Servico>) ps.deserializarListServico("ListServico");
                        listaAtrativos = (ArrayList<Atrativo>) ps.deserializarListAtrativo("ListAtrativo");
                    } 
                    catch (Exception ex) {
                        System.err.println("Falha ao deserializar! - " + ex.toString());
                    }
                    break;
            }
            System.out.println("1- Inserir Usuario Turista\n");
            System.out.println("2- Inserir Usuario Provedor\n");
            System.out.println("3- Cadastrar Serviço\n");
            System.out.println("4- Escrever Lista de Turista\n");
            System.out.println("5- Escrever Lista de Provedores\n");
            System.out.println("6- Escrever Lista de Serviços\n");
            System.out.println("7- Escrever Lista de Atrativos\n");
            System.out.println("8- Escrever serviços de cada atrativo\n");
            System.out.println("9- Salva Serializado\n");
            System.out.println("10- Recupera Serializado\n");
            System.out.println("0- sair\n");
            opcao=ler.nextInt();
        }while(opcao!=0);
    }
}
