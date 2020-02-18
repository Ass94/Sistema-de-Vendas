package br.com.vendas.teste;

import java.util.ArrayList;
import java.util.List;

import br.com.vendas.dao.FuncionarioDao;
import br.com.vendas.model.Funcionario;

public class FuncionarioDaoListarTeste {
	
	public static void main(String[] args) {
		
	
	List<Funcionario> funcionarios = new ArrayList<Funcionario>();
	funcionarios = new FuncionarioDao().listar();
	System.out.println(funcionarios);
	}
}
