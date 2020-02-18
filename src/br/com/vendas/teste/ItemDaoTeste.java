package br.com.vendas.teste;

import java.math.BigDecimal;

import br.com.vendas.dao.ItemDao;
import br.com.vendas.model.Item;
import br.com.vendas.model.Produto;
import br.com.vendas.model.Venda;

public class ItemDaoTeste {
	
	public static void main(String[] args) {
		
		Produto produto = new Produto();
		produto.setId(1L);
		
		Venda venda = new Venda();
		venda.setId(1L);
		
		Item item = new Item(5, new BigDecimal(50.00), produto, venda);
		new ItemDao().salvar(item);
		System.out.println("Item salvo com sucesso!");
	}

}
