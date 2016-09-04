package com.slothfx.dao.setter;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.slothfx.core.data.Project;

public class ProjectSetter implements ISetter {

	private Project project;
	
	@Override
	public boolean init(ResultSet set) throws SQLException {
		if(!set.next())
			return false;

		if(project == null)
			project = new Project();
		
		project.setId(set.getInt(1));
		project.setName(set.getString(2));

		return true;
	}

	public Project getProject() {
		return project;
	}
	
	public void setProject(Project project){
		this.project = project;
	}

}
