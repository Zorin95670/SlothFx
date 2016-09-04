package com.slothfx.core.controller;

import com.slothfx.core.Apps;

public abstract class AbstractController<T> implements IController<T> {

	private Apps apps;
	
	public AbstractController(Apps apps) {
		this.apps = apps;
	}
	
	@Override
	public Apps getApps() {
		return apps;
	}

}
