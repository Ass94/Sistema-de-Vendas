package br.com.vendas.teste;

import br.com.vendas.dao.FuncionarioDao;
import br.com.vendas.model.Funcionario;

public class FuncionarioDaoTesteAtualizar {
	
	public static void main(String[] args) {
		Funcionario funcionario = new Funcionario();
		funcionario.setId(1L);
		funcionario.setNome("Alex");
		funcionario.setCpf("423.016.168-94");
		funcionario.setSenha("895612");
		funcionario.setFuncao("Administrador");
		new FuncionarioDao().alterar(funcionario);
		System.out.println("Salvo com sucesso!");
	}

}
