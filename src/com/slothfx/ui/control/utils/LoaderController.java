package com.slothfx.ui.control.utils;

import java.io.File;

import com.slothfx.ui.component.executor.IExecutor;
import com.slothfx.ui.component.executor.InitExecutor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoaderController extends Application{

	IExecutor executor;
	
	public void setExecutor(IExecutor executor) {
		this.executor = executor;
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.initStyle(StageStyle.UNDECORATED);
		
		 // Load root layout from fxml file.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("../../scene/utils/LoaderLayout.fxml"));
        AnchorPane root= (AnchorPane) loader.load();
        

        // Show the scene containing the root layout.
        Scene scene = new Scene(root);
        stage.setScene(scene);
        VBox layout = (VBox) scene.lookup("#layout");
        ImageView loading = new ImageView(new File("ressources/images/loader.gif").toURI().toURL().toString());
        layout.getChildren().add(loading);
        stage.show();
        
        if(executor == null)
        	executor = new InitExecutor();
        executor.setScene(scene);
        executor.execute();
	}
	
	

}
