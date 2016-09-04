package com.slothfx.core.controller;

import java.util.ArrayList;
import java.util.List;

import com.slothfx.core.Apps;
import com.slothfx.core.data.Project;
import com.slothfx.dao.ORM;
import com.slothfx.dao.setter.ProjectsSetter;

public class ProjectController extends AbstractController<Project> {

	public ProjectController(Apps apps) {
		super(apps);
	}

	@Override
	public boolean create(Project p) {		
		ORM orm = getApps().getORM();
		
		ArrayList<String> parameters = new ArrayList<>();
		parameters.add(p.getName());
		parameters.add(p.getColor());
		
		long id = orm.insert("internal.create.project",parameters);
		p.setId(id);
		
		return (id == -1)?false:true;
	}

	@Override
	public boolean update(Project t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Project t) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean loadAll(List<Project> projects){
		ORM orm = getApps().getORM();
		
		ProjectsSetter setter = new ProjectsSetter(projects);
		orm.load("internal.load.projects", null, setter);
		
		return true;
	}

}
