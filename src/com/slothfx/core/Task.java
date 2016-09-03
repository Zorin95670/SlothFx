package com.slothfx.core;

import java.util.List;

public class Task {

	private Project project;

	private int id;
	private String name;

	private List<Time> times;
	private List<Tag> tags;

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
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

	public List<Time> getTimes() {
		return times;
	}

	public void setTimes(List<Time> taskTimes) {
		this.times = taskTimes;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
}
