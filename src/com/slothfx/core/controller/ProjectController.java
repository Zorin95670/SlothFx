package com.slothfx.core.controller;

import java.util.ArrayList;

import com.slothfx.core.Apps;
import com.slothfx.core.data.Project;
import com.slothfx.dao.ORM;

public class ProjectController extends AbstractController<Project> {

	public ProjectController(Apps apps) {
		super(apps);
	}

	@Override
	public boolean create(Project p) {
		String color = "#"+Integer.toHexString(p.getColor().hashCode()).substring(0, 6).toUpperCase();
		
		ORM orm = getApps().getORM();
		
		ArrayList<String> parameters = new ArrayList<>();
		parameters.add(p.getName());
		parameters.add(color);
		
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

}
