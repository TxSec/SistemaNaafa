package com.nafaa.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Database {
	
	private Connection connection = null;
	
	public Database(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return;
		}
	}
	
	/**
	 * 
	 */
	public void conectar(String host,String usuario,String password){
		try{
		connection = DriverManager.getConnection(host,usuario,password);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	if (connection != null) {
		System.out.println("Database Connected!");
	} else {
		System.out.println("Failed to make connection!");
	}
	}
	
	public void queryDDL(String query){
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int queryDMLSize(String query){
		int size = 0;
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				size++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return size;
	}

	public String queryDMLExtract(String dataName,String query) {
		String data = "";
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				data = rs.getString(dataName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return data;
	}
	
	public String queryDMLExtraAny(Query query,String... fields){
		return null;
		
	}

}
