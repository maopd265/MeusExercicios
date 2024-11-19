package teste;

public class GuardadorDeArray {
	private Conta[] referencias;
    private int posicaoLivre;
    
    public GuardadorDeArray() {
		// TODO Auto-generated constructor stub
    	this.referencias=new Conta[10];
    	this.posicaoLivre=0;
	}
    public void adiciona(Conta cont) 
    {
    	referencias[this.posicaoLivre]=cont;
    	this.posicaoLivre++;
    }
    public int getQuantidadeDeElementos() 
    {
    	return this.posicaoLivre;
    }
    public Conta getRef(int pos) 
    {
       return this.referencias[pos];
    }
}
