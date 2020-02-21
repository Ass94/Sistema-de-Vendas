package br.com.vendas.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.vendas.model.Fornecedor;
import br.com.vendas.model.Produto;

public class ProdutoDao extends DAO {
	
	private final String SALVAR = "{ call pInstVenProd(?, ?, ?, ?) }";
	private final String LISTAR_TODOS = "{ call pSeltVenProd }";
	private final String BUSCAR_POR_ID = "{ call pSeltVenProd2(?) }";
	
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
	
	public List<Produto> listar() {
		CallableStatement prepared = null;
		ResultSet result = null;
		List<Produto> produtos = new ArrayList<Produto>();
		try {
			prepared = connection.prepareCall(LISTAR_TODOS);
			result = prepared.executeQuery();
			while(result.next()) {
				Fornecedor fornecedor = new Fornecedor();
				fornecedor.setId(result.getLong("nIdForn"));
				fornecedor.setDescricao(result.getString("cDescForn"));
				
				Produto produto = new Produto();
				produto.setId(result.getLong("nIdProd"));
				produto.setDescricao(result.getString("cDescProd"));
				produto.setPreco(result.getBigDecimal("nPrecProd"));
				produto.setQuantidade(result.getInt("nQuantProd"));
				produto.setFornecedor(fornecedor);
				produtos.add(produto);
			}
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return produtos;
	}
	
	public Produto buscarPorId(Long codigo) {
		CallableStatement prepared = null;
		ResultSet result = null;
		Produto retorno = null;
		try {
			prepared = connection.prepareCall(BUSCAR_POR_ID);
			prepared.setLong(1, codigo);
			result = prepared.executeQuery();
			if (result.next()) {
				Fornecedor fornecedor = new Fornecedor();
				fornecedor.setId(result.getLong("nIdForn"));
				fornecedor.setDescricao(result.getString("cDescForn"));
				
				retorno = new Produto();
				retorno.setId(result.getLong("nIdProd"));
				retorno.setDescricao(result.getString("cDescProd"));
				retorno.setPreco(result.getBigDecimal("nPrecProd"));
				retorno.setQuantidade(result.getInt("nQuantProd"));
				retorno.setFornecedor(fornecedor);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return retorno;
	}

}
