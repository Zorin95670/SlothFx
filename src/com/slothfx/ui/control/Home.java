package com.slothfx.ui.control;

import com.slothfx.core.Apps;
import com.slothfx.ui.component.executor.FirstProjectExecutor;
import com.slothfx.ui.control.project.CreateProjectControl;
import com.slothfx.ui.control.utils.LoaderController;

import javafx.stage.Stage;

public class Home {

	public static void main(String[] args) {
		LoaderController.launch(LoaderController.class);
	}
	
	private Apps apps;
	
	public void start() {
		if(apps.getProjects().size() == 0){
			FirstProjectExecutor executor = new FirstProjectExecutor(this);
			CreateProjectControl controller = new CreateProjectControl(executor);
			controller.setApps(apps);
			controller.start(new Stage());
			return;
		}

	}
	
	public Apps getApps() {
		return apps;
	}
	
	public void setApps(Apps apps) {
		this.apps = apps;
	}

}
