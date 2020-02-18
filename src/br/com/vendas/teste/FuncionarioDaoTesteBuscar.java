package br.com.vendas.teste;

import br.com.vendas.dao.FuncionarioDao;
import br.com.vendas.model.Funcionario;

public class FuncionarioDaoTesteBuscar {
	
	public static void main(String[] args) {
		
		
		Funcionario funcionario = new Funcionario();
		funcionario = new FuncionarioDao().buscarPorId(1L);
		System.out.println(funcionario);
	}

}
