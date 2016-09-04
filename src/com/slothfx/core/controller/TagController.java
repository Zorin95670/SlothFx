package com.slothfx.core.controller;

import java.util.List;

import com.slothfx.core.Apps;
import com.slothfx.core.data.Tag;
import com.slothfx.dao.ORM;
import com.slothfx.dao.setter.TagsSetter;

public class TagController extends AbstractController<Tag> {

	public TagController(Apps apps) {
		super(apps);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Tag t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Tag t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Tag t) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean loadAll(List<Tag> tags){
		ORM orm = getApps().getORM();
		
		TagsSetter setter = new TagsSetter(tags);
		orm.load("internal.load.tags", null, setter);
		
		return true;
	}

}
