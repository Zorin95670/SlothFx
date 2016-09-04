package com.slothfx.ui.control.project;

import java.io.IOException;

import com.slothfx.core.Apps;
import com.slothfx.core.data.Project;
import com.slothfx.ui.component.textfield.MandatoryText;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CreateProjectControl extends Application {

	private Apps apps = new Apps();
	private Stage primaryStage;
	private BorderPane rootLayout;
	private MandatoryText projectName;
	private ColorPicker projectColor;
	private Button create, close;
	private boolean createState = true;
	
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
			projectName.getField().requestFocus();
			projectName.getField().setOnKeyReleased(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent event) {
					if(event.getCode().equals(KeyCode.ENTER)){
						create.requestFocus();
					}
				}
			});
			
            projectColor = (ColorPicker) scene.lookup("#color");

            projectColor.valueProperty().addListener(new ChangeListener<Color>() {
            	@Override
            	public void changed(ObservableValue<? extends Color> observable, Color oldValue, Color newValue) {
            		createState = false;
            		create.requestFocus();
            	}
			});
            
            create.setOnMouseReleased(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					createProject();
				}
			});
            create.setOnKeyReleased(new EventHandler<KeyEvent>() {

				@Override
				public void handle(KeyEvent event) {
					if(createState && event.getCode().equals(KeyCode.ENTER)){
						createProject();
					}
					createState = true;
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
	public void createProject(){
		if(!projectName.verify()){
			projectName.getField().requestFocus();
			return;
		}

		Project project = new Project();
		project.setName(projectName.getText());
		project.setColor(projectColor.getValue());
		
		apps.getProjectController().create(project);
		
		primaryStage.close();
	}
	
}
