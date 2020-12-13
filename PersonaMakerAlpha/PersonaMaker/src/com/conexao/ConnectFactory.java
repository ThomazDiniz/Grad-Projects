package com.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectFactory {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String BANCO_ACESSO = "JDBC:MYSQL://127.0.0.1/personamaker";
	
	public static Connection getConnection(){
		try {
			System.out.println("Tentando se Conectar...");
			return DriverManager.getConnection(BANCO_ACESSO,"root", "");
		} catch (SQLException e) {
			System.out.println("Deu Ruim!");
			throw new RuntimeException();
		}
	}
	public static Statement criaStatement(Connection conexao){
		try {
			System.out.println("Criando Statement");
			return conexao.createStatement();
		} catch (SQLException e) {
			System.out.println("Deu ruim no Statement");
			throw new RuntimeException();
		}
	}
	
	public static PreparedStatement criaPreparedStatement(Connection conexao, String query){
		try {
			System.out.println("Criando Statement");
			return conexao.prepareStatement(query);
		} catch (SQLException e) {
			System.out.println("Deu ruim no Statement");
			throw new RuntimeException();
		}
	}
	
	public static void fechaConexao(Connection conexao){
		try {
			System.out.println("Conexão fechada");
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

}
