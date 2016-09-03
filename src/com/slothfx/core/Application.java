package com.slothfx.core;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import com.slothfx.dao.ORM;

public class Application {
	
	private List<Project> projects;
	private Properties config;
	private ORM orm;
	
	public Application() {
		initConfig();
		
		orm = new ORM(this);
		
		initInternalDataBase();
	}
	
	public boolean initConfig(){
		String configFile = "ressources"+File.separator+"config.ini";
		config = new Properties();
		try{
			FileInputStream stream = new FileInputStream(configFile);
			config.load(stream);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean initInternalDataBase(){
		if(new File("sloth.db").exists()){
			return true;
		}
		String[] files = getConfig("sql.init.sql").split(", ");
		for(int i = 0 ; i < files.length ; i++)
			orm.create("internal.init."+files[i]);
		
		return true;
	}

	public String getPath(String name) {
		return getConfig("path."+name).replace(".",File.separator);
	}
	
	public String getConfig(String key){
		return config.getProperty(key);
	}

	public ORM getORM() {
		return orm;
	}
	
	
}
