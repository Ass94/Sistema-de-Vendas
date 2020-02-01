package br.com.vendas.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private final static String URL = "jdbc:jtds:sqlserver://DESKTOP-5MGVTA8:1433;DataBaseName=VD0000";
	private final static String USER = "sa";
	private final static String PASSWORD = "@123456";

	public Connection getConnection() {
		try {

			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			return DriverManager.getConnection(URL, USER, PASSWORD);

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void main(String[] args) {
		new ConnectionFactory().getConnection();
		System.out.println("Conectado com sucesso!");
	}

}
