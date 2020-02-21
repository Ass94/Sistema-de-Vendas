package br.com.vendas.teste;

import java.util.ArrayList;
import java.util.List;

import br.com.vendas.dao.ProdutoDao;
import br.com.vendas.model.Produto;

public class ProdutoDAOTesteListar {
	
	public static void main(String[] args) {
		List<Produto> produtos = new ArrayList<>();
		produtos = new ProdutoDao().listar();
		System.out.println(produtos);
	}

}
