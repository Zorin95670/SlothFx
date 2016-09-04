package com.slothfx.ui.component.executor;

import javafx.scene.Scene;

public abstract class Executor implements IExecutor {

	private Scene scene;
	
	@Override
	public void setScene(Scene scene) {
		this.scene = scene;
	}

	@Override
	public Scene getScene() {
		return scene;
	}

}
