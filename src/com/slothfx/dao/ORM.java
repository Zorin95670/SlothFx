package com.slothfx.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import com.slothfx.core.Application;
import com.slothfx.dao.setter.ISetter;

public class ORM {

	private Application application;

	private HashMap<String, Connection> connections;
	private HashMap<String, Request> requests;

	public ORM(Application application) {
		this.application = application;

		connections = new HashMap<>();
		requests = new HashMap<>();
	}

	public Connection getConnection(String dataBase) {
		if (!connections.containsKey(dataBase)) {
			initConnection(dataBase);
		}

		return connections.get(dataBase);
	}

	public boolean initConnection(String dataBase) {
		Connection connection = null;
		String driver, location;

		if (dataBase.equals("internal")) {
			driver = "org.sqlite.JDBC";
			location = "jdbc:sqlite:sloth.db";
		} else {
			driver = "";
			location = "";
		}

		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(location);
			connections.put(dataBase, connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
		// TODO if internal run init
		if(dataBase.equals("internal"))
			exec("internal.init.init");
		return true;
	}
	
	public void close(){
		for(String key : connections.keySet()){
			try{
				connections.get(key).close();
				connections.remove(key);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	public Request getRequest(String name) {
		if (requests.containsKey(name)) {
			return requests.get(name);
		}

		Request request = new Request();
		request.init(application, name);

		requests.put(name, request);

		return request;
	}

	public boolean exec(String name){
		Request request = getRequest(name);
		
		Connection connection = getConnection(request.getDataBase());
		
		try {
			Statement statement = connection.createStatement();
			
			statement.execute(request.getQuery());
			
			statement.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}

		return true;
	}
	
	public boolean load(String name, List<String> parameters, ISetter setter){
		Request request = getRequest(name);
		
		Connection connection = getConnection(request.getDataBase());
		
		try {
			PreparedStatement statement = connection.prepareStatement(request.getQuery());
			if(parameters != null){
				for(int i = 0 ; i < parameters.size() ; i++){
					System.out.println(parameters.get(i));
					statement.setString(i+1, parameters.get(i));
				}
			}
			ResultSet set = statement.executeQuery();
			
			setter.init(set);
			
			set.close();
			statement.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}

		return true;
	}
}
