package testeJavaUtil;

public class Conta {
private String nomeDaPessoa;

public String getNomeDaPessoa() {
	return nomeDaPessoa;
}

public void setNomeDaPessoa(String nomeDaPessoa) {
	this.nomeDaPessoa = nomeDaPessoa;
}

 
@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "nomeDaPessoa :"+this.getNomeDaPessoa();
	}
}
