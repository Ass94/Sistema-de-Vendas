package br.com.vendas.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.vendas.model.Funcionario;

public class FuncionarioDao extends DAO {

	private final String SALVAR = "{ call pInstVenFunc(?,?,?,?) }";
	private final String LISTAR_TODOS = "{ call pSeltVenFunc }";
	private final String LISTAR_POR_ID = "{ call pSeltVenFunc2(?) }";
	private final String ATUALIZAR = "{ call pUpdtVenFunc (?,?,?,?,?) }";
	private final String EXCLUIR = "{ call pDeltVenFunc(?) }";

	public void salvar(Funcionario funcionario) {
		CallableStatement prepared = null;
		try {
			prepared = connection.prepareCall(SALVAR);
			prepared.setString(1, funcionario.getNome());
			prepared.setString(2, funcionario.getCpf());
			prepared.setString(3, funcionario.getSenha());
			prepared.setString(4, funcionario.getFuncao());
			prepared.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Funcionario> listar() {
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		CallableStatement prepared = null;
		ResultSet result = null;
		try {
			prepared = connection.prepareCall(LISTAR_TODOS);
			result = prepared.executeQuery();
			while (result.next()) {
				Funcionario funcionario = new Funcionario();
				funcionario.setId(result.getLong("nIdFunc"));
				funcionario.setNome(result.getString("cNomeFunc"));
				funcionario.setCpf(result.getString("cCpfFunc"));
				funcionario.setSenha(result.getString("cSenFunc"));
				funcionario.setFuncao(result.getString("cFunFunc"));
				funcionarios.add(funcionario);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return funcionarios;
	}

	public Funcionario buscarPorId(Long codigo) {
		CallableStatement prepared = null;
		ResultSet result = null;
		Funcionario retorno = null;
		try {
			prepared = connection.prepareCall(LISTAR_POR_ID);
			prepared.setLong(1, codigo);
			result = prepared.executeQuery();
			if (result.next()) {
				retorno = new Funcionario();
				retorno.setId(result.getLong("nIdFunc"));
				retorno.setNome(result.getString("cNomeFunc"));
				retorno.setCpf(result.getString("cCpfFunc"));
				retorno.setSenha(result.getString("cSenFunc"));
				retorno.setFuncao(result.getString("cFunFunc"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return retorno;

	}

	public void alterar(Funcionario funcionario) {

		CallableStatement prepared = null;
		try {
			prepared = connection.prepareCall(ATUALIZAR);
			prepared.setLong(1, funcionario.getId());
			prepared.setString(2, funcionario.getNome());
			prepared.setString(3, funcionario.getCpf());
			prepared.setString(4, funcionario.getSenha());
			prepared.setString(5, funcionario.getFuncao());
			prepared.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void excluir(Funcionario funcionario) {
		CallableStatement prepared = null;
		try {
			prepared = connection.prepareCall(EXCLUIR);
			prepared.setLong(1, funcionario.getId());
			prepared.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
