package br.com.alura.rh.service;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Cargo;
import br.com.alura.rh.model.Funcionario;
import jdk.nashorn.internal.runtime.ScriptEnvironment.FunctionStatementBehavior;

public class PromocaoService {

	public PromocaoService() {
		// TODO Auto-generated constructor stub
	}
    public void promover(Funcionario funcionario, boolean metaSalarial)
    {
    	Cargo cargoAtual= funcionario.getCargo();
    	if (Cargo.GERENTE == cargoAtual) {
			throw new ValidacaoException("Gerentes não podem ser promovidos");
		}
    	if (metaSalarial) {
    		Cargo novoCargo = cargoAtual.getProximoCargo();
			
		}else 
		{
			throw new ValidacaoException("Funcionario nao atingiu o esperado");
		}
    }
}
