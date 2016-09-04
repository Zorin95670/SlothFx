package com.slothfx.core.data;

import java.util.ArrayList;
import java.util.List;

import com.slothfx.core.Apps;
import com.slothfx.dao.ORM;
import com.slothfx.dao.setter.TagsSetter;
import com.slothfx.dao.setter.TasksSetter;

import javafx.scene.paint.Color;

public class Project {

	private long id;
	private String name;
	private String color;

	private List<Task> tasks;
	private List<Tag> tags;
	
	public Project() {
		tasks = new ArrayList<>();
		tags = new ArrayList<>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color){
		this.color = color;
	}

	public void setColor(Color color) {
		this.color = "#"+Integer.toHexString(color.hashCode()).substring(0, 6).toUpperCase();
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	
	public void loadTags(Apps application){
		ORM orm = application.getORM();
		
		TagsSetter setter = new TagsSetter(tags);
		
		ArrayList<String> parameters = new ArrayList<>();
		parameters.add(getId()+"");
		orm.load("internal.load.projectTags", parameters, setter);
		
	}
	
	public void loadTasks(Apps application){
		ORM orm = application.getORM();
		
		TasksSetter setter = new TasksSetter(tasks);
		
		ArrayList<String> parameters = new ArrayList<>();
		parameters.add(getId()+"");
		orm.load("internal.load.projectTasks", parameters, setter);
		
	}

	@Override
	public String toString() {
		return "{id="+id+", name="+name+", tasks="+tasks+"+tags="+tags+"}";
	}
}
