package com.nafaa.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Database {
	
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private Connection connection = null;
	
	public static final Database database = new Database();
	
	/**
	 * Database instance.
	 * @return The instance.
	 */
	public static Database getDatabase(){
		return database;
	}
	
	
	
	private Database(){
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
	
	public void easyQuery(String query){
		Statement stmt;
		try {
			stmt = connection.createStatement();
			stmt.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Map<Integer, List<String>> queryDMLExtraAny(Query query,String... fields){
		Map<Integer, List<String>> list = new HashMap<Integer,List<String>>(); 
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query.getQuery());
			int j = 0;
			while(rs.next()){
				List<String> arrayList = new ArrayList<String>();
				for(int i = 0 ; i < fields.length;i++)
					arrayList.add(rs.getString(fields[i]));
					list.put(j, arrayList);
				j++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
		
	}

}
