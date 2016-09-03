package com.slothfx.core;

import java.util.ArrayList;
import java.util.List;

import com.slothfx.dao.ORM;
import com.slothfx.dao.setter.TagsSetter;

public class Project {

	private int id;
	private String name;

	private List<Task> tasks;
	private List<Tag> tags;
	
	public Project() {
		tasks = new ArrayList<>();
		tags = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	public void loadTags(Application application){
		ORM orm = application.getORM();
		
		TagsSetter setter = new TagsSetter(tags);
		
		ArrayList<String> parameters = new ArrayList<>();
		parameters.add(getId()+"");
		orm.load("internal.load.projectTags", parameters, setter);
		
	}

	@Override
	public String toString() {
		return "{id="+id+", name="+name+", tasks="+tasks+"+tags="+tags+"}";
	}
}
