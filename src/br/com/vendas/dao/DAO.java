package br.com.vendas.dao;

import java.sql.Connection;

import br.com.vendas.connection.ConnectionFactory;

public abstract class DAO {

	Connection connection;

	public DAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

}
