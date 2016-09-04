package com.slothfx.dao.setter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.slothfx.core.data.Project;


public class ProjectsSetter implements ISetter {

	private List<Project> projects;
	
	public ProjectsSetter(List<Project> projects) {
		setProjects(projects);
	}

	@Override
	public boolean init(ResultSet set) throws SQLException {
		ProjectSetter setter = new ProjectSetter();
		
		while(setter.init(set)){
			projects.add(setter.getProject());
			setter.setProject(new Project());
		}
		
		return true;

	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

}
