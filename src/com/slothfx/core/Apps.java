package com.slothfx.core;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.slothfx.core.controller.ProjectController;
import com.slothfx.core.controller.TagController;
import com.slothfx.core.data.Project;
import com.slothfx.core.data.Tag;
import com.slothfx.dao.ORM;

public class Apps {
	
	private List<Project> projects = new ArrayList<>();
	private List<Tag> tags = new ArrayList<>();
	private Properties config;
	private ORM orm;
	private ProjectController projectController;
	private TagController tagController;
	
	public Apps() {
		initConfig();
		
		orm = new ORM(this);
		
		initInternalDataBase();
		
		projectController = new ProjectController(this);
		setTagController(new TagController(this));
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
			orm.exec("internal.init."+files[i]);
		
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

	public ProjectController getProjectController() {
		return projectController;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public TagController getTagController() {
		return tagController;
	}

	public void setTagController(TagController tagController) {
		this.tagController = tagController;
	}
	
	
}
