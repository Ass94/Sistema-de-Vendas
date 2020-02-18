package br.com.vendas.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.vendas.model.Fornecedor;

public class FornecedorDao extends DAO {
	
	private final String SALVAR = "{ call pInstVenForn(?) }";
	private final String LISTAR_TODOS = "{ call pSeltVenForn }";
	private final String ATUALIZAR = "{ call pUpdtVenForn(?,?) }";
	private final String BUSCAR_POR_ID = "{ call pSeltVenForn2(?) }";
	private final String EXCLUIR = "{ call pDeltVenForn(?) }";
	
	public void salvar(Fornecedor fornecedor) {
		CallableStatement prepared = null;
		try {
			prepared = connection.prepareCall(SALVAR);
			prepared.setString(1, fornecedor.getDescricao());
			prepared.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public List<Fornecedor> listar(){
		CallableStatement prepared = null;
		ResultSet result = null;
		List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
		try {
			prepared = connection.prepareCall(LISTAR_TODOS);
			result = prepared.executeQuery();
			while(result.next()) {
				Fornecedor fornecedor = new Fornecedor();
				fornecedor.setId(result.getLong("nIdForn"));
				fornecedor.setDescricao(result.getString("cDescForn"));
				fornecedores.add(fornecedor);
			}
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		return fornecedores;
	}
	
	public void alterar(Fornecedor fornecedor) {
		CallableStatement prepared = null;
		try {
			prepared = connection.prepareCall(ATUALIZAR);
			prepared.setLong(1, fornecedor.getId());
			prepared.setString(2, fornecedor.getDescricao());
			prepared.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Fornecedor buscarPorId(Long codigo) {
		CallableStatement prepared = null;
		ResultSet result = null;
		Fornecedor retorno = null;
		try {
			prepared = connection.prepareCall(BUSCAR_POR_ID);
			prepared.setLong(1, codigo);
			result = prepared.executeQuery();
			if (result.next()) {
			retorno  = new Fornecedor();
			retorno.setId(result.getLong("nIdForn"));
			retorno.setDescricao(result.getString("cDescForn"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return retorno;
	}
	
	public void excluir(Fornecedor fornecedor) {
		CallableStatement prepared = null;
		try {
			prepared = connection.prepareCall(EXCLUIR);
			prepared.setLong(1, fornecedor.getId());
			prepared.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
