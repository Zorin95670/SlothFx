package com.slothfx.ui.component.executor;

import com.slothfx.ui.control.Home;

import javafx.stage.Stage;

public class FirstProjectExecutor extends Executor {

	private Home home;
	
	public FirstProjectExecutor(Home home) {
		this.home = home;
	}
	
	@Override
	public boolean execute() {
		Stage stage = (Stage)getScene().getWindow();
		stage.close();
		home.start();
		return false;
	}

}
