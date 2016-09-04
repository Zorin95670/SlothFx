package com.slothfx.ui.component.executor;

import com.slothfx.core.Apps;
import com.slothfx.ui.control.Home;

import javafx.scene.control.Label;
import javafx.stage.Stage;

public class InitExecutor extends Executor {

	private Home home;
	public InitExecutor() {
		setHome(new Home());
	}
	
	@Override
	public boolean execute() {
		Label info = (Label) getScene().lookup("#info");
		
		info.setText("Initialisation de l'application");
		home.setApps(new Apps());
	
		info.setText("Chargement des projets.");
		home.getApps().getProjectController().loadAll(home.getApps().getProjects());
		
		info.setText("Chargement des tags.");
		home.getApps().getTagController().loadAll(home.getApps().getTags());
		
		Stage stage = (Stage)getScene().getWindow();
		stage.close();
		home.start();
		
		return false;
	}

	public Home getHome() {
		return home;
	}

	public void setHome(Home home) {
		this.home = home;
	}

}
