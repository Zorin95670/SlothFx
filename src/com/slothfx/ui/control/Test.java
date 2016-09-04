package com.slothfx.ui.control;

import com.slothfx.core.controller.IExecutor;
import com.slothfx.core.data.Tag;
import com.slothfx.ui.control.tag.TagController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Test extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(this.getClass().getResource("../scene/TestLayout.fxml"));
			
			AnchorPane rootLayout = (AnchorPane) loader.load();
			
			Scene scene = new Scene(rootLayout);
			stage.setScene(scene);
			stage.show();
			
			HBox tags = (HBox) scene.lookup("#tags");

			Tag tag = new Tag();
			tag.setId(1);
			tag.setName("Tesazerazerazert");
			tag.setColor("#0000FF");
			Tag tag2 = new Tag();
			tag2.setId(2);
			tag2.setName("Test");
			tag2.setColor("#00FF00");
			
			TagController tagController = new TagController(tag);
			
			tagController.init(scene, tags, new IExecutor() {
				
				@Override
				public boolean execute() {
					// TODO Auto-generated method stub
					return true;
				}
			});
			
			TagController tagController2 = new TagController(tag2);
			
			tagController2.init(scene, tags, new IExecutor() {
				
				@Override
				public boolean execute() {
					// TODO Auto-generated method stub
					return true;
				}
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
