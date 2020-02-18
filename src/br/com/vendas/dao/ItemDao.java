package br.com.vendas.dao;

import java.sql.CallableStatement;
import java.sql.SQLException;

import br.com.vendas.model.Item;

public class ItemDao extends DAO {
	
	private final String SALVAR = "{ call pInstVenItem(?,?,?,?) }";
	
	public void salvar(Item item) {
		CallableStatement prepared = null;
		
		try {
			prepared = connection.prepareCall(SALVAR);
			prepared.setInt(1, item.getQuantidade());
			prepared.setBigDecimal(2, item.getValorParcial());
			prepared.setLong(3, item.getProduto().getId());
			prepared.setLong(4, item.getVenda().getId());
			prepared.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
