package com.slothfx.core.controller;

import com.slothfx.core.Apps;

public interface IController<T> {

	Apps getApps();

	public boolean create(T t);
	public boolean update(T t);
	public boolean delete(T t);
}
