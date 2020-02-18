package br.com.vendas.dao;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import br.com.vendas.model.Venda;

public class VendaDao extends DAO {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private final String SALVAR = "{ call pInstVenVend (?,?,?) }";

	public void salvar(Venda venda) {
		CallableStatement prepared = null;
		try {
			prepared = connection.prepareCall(SALVAR);
			prepared.setDate(1, new Date(venda.getHorario().getTimeInMillis()));
			prepared.setBigDecimal(2, venda.getValorTotal());
			prepared.setLong(3, venda.getFuncionario().getId());
			prepared.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
