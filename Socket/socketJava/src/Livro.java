
import java.io.Serializable;

public class Livro  implements Serializable{
     
    
    
    private String tituloLivro;
    private String autorLivro;
    private String edicaoLivro;
    private int anoPublicacao;
        

    public Livro() {
        
    }
    /**
     * @return int return the codlivro
     */
    // public int getCodlivro() {
    //     return codlivro;
    // }

    // /**
    //  * @param codlivro the codlivro to set
    //  */
    // public void setCodlivro(int codlivro) {
    //     this.codlivro = codlivro;
    // }

    /**
     * @return String return the tituloLivro
     */
    public String getTituloLivro() {
        return tituloLivro;
    }

    /**
     * @param tituloLivro the tituloLivro to set
     */
    public void setTituloLivro(String tituloLivro) {
        this.tituloLivro = tituloLivro;
    }

    /**
     * @return String return the autorLivro
     */
    public String getAutorLivro() {
        return autorLivro;
    }

    /**
     * @param autorLivro the autorLivro to set
     */
    public void setAutorLivro(String autorLivro) {
        this.autorLivro = autorLivro;
    }

    /**
     * @return int return the edicaoLivro
     */
    public String getEdicaoLivro() {
        return edicaoLivro;
    }

    /**
     * @param edicaoLivro the edicaoLivro to set
     */
    public void setEdicaoLivro(String edicaoLivro) {
        this.edicaoLivro = edicaoLivro;
    }

    /**
     * @return int return the anoPublicacao
     */
    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    /**
     * @param anoPublicacao the anoPublicacao to set
     */
    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

}