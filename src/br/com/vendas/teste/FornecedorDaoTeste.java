package br.com.vendas.teste;

import br.com.vendas.dao.FornecedorDao;
import br.com.vendas.model.Fornecedor;

public class FornecedorDaoTeste {
	
	public static void main(String[] args) {
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setDescricao("Papelaria");
		new FornecedorDao().salvar(fornecedor);
		System.out.println("Fornecedor Salvo com sucesso!");
	}

}
