package br.com.vendas.teste;

import org.junit.Test;

import br.com.vendas.dao.FuncionarioDao;
import br.com.vendas.model.Funcionario;

public class FuncionarioDaoTeste {
		
		@Test
		public void salvar() {
		Funcionario funcionario = new Funcionario("Alice", "41816275828", "@123456", "Analista");
		new FuncionarioDao().salvar(funcionario);
		}

}
