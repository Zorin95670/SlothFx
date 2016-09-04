package com.slothfx.ui.component.executor;

import javafx.scene.Scene;

public interface IExecutor {

	boolean execute();
	void setScene(Scene scene);
	Scene getScene();
}
