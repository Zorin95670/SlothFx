package com.slothfx;

import com.slothfx.core.Apps;
import com.slothfx.ui.control.project.CreateProjectControl;

public class Runner {

	public static void main(String[] args) {
		Apps apps = new Apps();
		
		CreateProjectControl scene = new CreateProjectControl();
		
		scene.run();
		
	}

}
