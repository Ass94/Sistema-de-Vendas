package br.com.vendas.dao;

import java.sql.CallableStatement;
import java.sql.SQLException;

import br.com.vendas.model.Produto;

public class ProdutoDao extends DAO {
	
	private String SALVAR = "{ call pInstVenProd(?, ?, ?, ?) }";
	
	public void salvar(Produto produto) {
		CallableStatement prepared = null;
		try {
			prepared = connection.prepareCall(SALVAR);
			prepared.setString(1, produto.getDescricao());
			prepared.setBigDecimal(2, produto.getPreco());
			prepared.setInt(3, produto.getQuantidade());
			prepared.setLong(4, produto.getFornecedor().getId());
			prepared.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
