package br.com.vendas.teste;

import java.math.BigDecimal;

import br.com.vendas.dao.FornecedorDao;
import br.com.vendas.dao.ProdutoDao;
import br.com.vendas.model.Fornecedor;
import br.com.vendas.model.Produto;

public class ProdutoDaoTeste {
	
	public static void main(String[] args) {
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setId(3L);
		fornecedor.setDescricao("Drogaria");
		new FornecedorDao().salvar(fornecedor);
		
		Produto produto = new Produto();
		produto.setDescricao("Dipirona");
		produto.setPreco(new BigDecimal(2.00));
		produto.setQuantidade(2);
		produto.setFornecedor(fornecedor);
		new ProdutoDao().salvar(produto);
		
		System.out.println("Produto salvo com sucesso!");
	}

}
