import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
 
import java.sql.ResultSet;
import java.sql.SQLException;
public class BancoDeDados {
     
    public Connection getConnection()  throws SQLException{
      
     
        Connection conexao= DriverManager.getConnection("jdbc:postgresql://localhost:5432/livros","postgres","23325344ck");
       return conexao;
   }


   public  boolean VerificarExistencia(Livro livro)   
        {
            
              System.out.println("Estou aqui");
             
          boolean b=false;
            Connection conexao;
             
            try {
              System.out.println("TRY INICIO DO COD");
                conexao = this.getConnection();
                System.out.println("TRY INICIO DO COD2");
                String sql= "SELECT livros.titulo,autor.nome,edicao.numero,edicao.ano FROM livros, autor,edicao,livroautor WHERE livros.codigo = livroautor.codigolivro AND livros.codigo=edicao.codigolivro AND autor.codigo=livroautor.codigoautor AND livros.titulo LIKE '"+livro.getTituloLivro()+"%' AND autor.nome LIKE '"+livro.getAutorLivro()+"%';";
                
                 
                  Statement stm = conexao.createStatement();
                  System.out.println("RST2: ");
                  stm.execute(sql);
                  System.out.println("RST1: ");
                  ResultSet rst = stm.getResultSet();
                  System.out.println("RST: "+rst);
                if(rst.next())
                { 
                  System.out.println("Estou aqui 2");
                   b= true;
                }else
                {
                  b=false;
                }
                 
                rst.close();
                stm.close();
                
                conexao.close();
                
            } catch (SQLException e) {
              
                e.printStackTrace();
                e.getMessage();
            } 
              
              
                
              
              
            System.out.println("Estou aqui 3");
             
            return b;
             
                  
                  
                  //EscreveArray(array);
                 
       }
}