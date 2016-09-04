package com.slothfx.core.data;

import com.slothfx.utils.ColorUtils;

import javafx.scene.paint.Color;

public class Tag {

	private long id;
	private String name;
	private String color;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getColor(){
		return color;
	}

	public void setColor(String color){
		this.color = color;
	}
	
	public void setColor(Color color) {
		this.color = ColorUtils.convert(color);
		System.out.println(this.color);
	}
	
	@Override
	public String toString() {
		return "{id="+id+", name="+name+"}";
	}
}
