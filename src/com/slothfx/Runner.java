package com.slothfx;

import java.util.ArrayList;

import com.slothfx.core.Application;
import com.slothfx.core.Project;
import com.slothfx.dao.ORM;
import com.slothfx.dao.setter.ProjectsSetter;

public class Runner {

	public static void main(String[] args) {
		Application app = new Application();
		ORM orm = app.getORM();
		ProjectsSetter setter = new ProjectsSetter(new ArrayList<Project>());

		orm.load("internal.load.projects", null, setter);
		
		for(Project p : setter.getProjects()){
			p.loadTags(app);
			System.out.println(p.getTags());
			break;
		}
		orm.close();
		
	}

}
