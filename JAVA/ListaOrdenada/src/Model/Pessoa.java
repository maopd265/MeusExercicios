package Model;

public class Pessoa implements Comparable<Pessoa> {
    private String nome;
    private String cidade;
    

    /* Pessoa(String nome, String cidade)
     */
    public  Pessoa(String nome, String cidade) {
      this.nome=nome;  
      this.cidade=cidade;      
    }

    /**
     * @return String return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return String return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

@Override
public int compareTo(Pessoa outraPessoa)
{
    if ((this.nome.compareTo(outraPessoa.getNome())<0)) { 
        return -1; 
        } if ((this.nome.compareTo(outraPessoa.getNome())>0)) { 
        return 1; 
        } else if((this.nome.compareTo(outraPessoa.getNome())==0) && this.cidade.compareTo(outraPessoa.getCidade())<0)
        {
            return -1;
        }else if((this.nome.compareTo(outraPessoa.getNome())==0) && this.cidade.compareTo(outraPessoa.getCidade())>0)
        {
            return 1;
        }
        return 0; 
}

}
