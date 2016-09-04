package com.slothfx.ui.control.project;

import java.io.IOException;

import com.slothfx.core.Apps;
import com.slothfx.core.data.Project;
import com.slothfx.ui.component.textfield.MandatoryText;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class CreateProjectControl extends Application {

	private Apps apps = new Apps();
	private Stage primaryStage;
	private BorderPane rootLayout;
	private MandatoryText projectName;
	private ColorPicker projectColor;
	private Button create, close;
	
	@Override
	public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AddressApp");

        initRootLayout();

	}
	
	public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(this.getClass().getResource("../../scene/project/CreateProjectLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();

            create = (Button) scene.lookup("#create");
            close = (Button) scene.lookup("#close");
            projectName = new MandatoryText(scene.lookup("#name"));
            projectColor = (ColorPicker) scene.lookup("#color");
            
            create.setOnMouseReleased(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					if(!projectName.verify()){
						return;
					}

					Project project = new Project();
					project.setName(projectName.getText());
					project.setColor(projectColor.getValue());
					
					apps.getProjectController().create(project);
					
					primaryStage.close();
				}
			});
            close.setOnMouseReleased(new EventHandler<MouseEvent>() {
            	
            	@Override
            	public void handle(MouseEvent event) {
            		primaryStage.close();
            	}
			});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public static void run() {
		launch();
	}
	
}
