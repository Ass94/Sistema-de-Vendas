package br.com.vendas.teste;

import br.com.vendas.dao.ProdutoDao;
import br.com.vendas.model.Produto;

public class ProdutoDaoTesteBuscar {
	
	public static void main(String[] args) {
		Produto produto = new ProdutoDao().buscarPorId(1L);
		System.out.println(produto);
	}

}
