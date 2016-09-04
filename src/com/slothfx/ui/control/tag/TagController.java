package com.slothfx.ui.control.tag;

import com.slothfx.core.data.Tag;
import com.slothfx.ui.component.executor.IExecutor;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class TagController {

	private Tag tag;
	private AnchorPane rootLayout;
	private StackPane layout;
	private Text name;
	private ImageView delete;
	
	public TagController(Tag tag) {
		this.tag = tag;
	}
	
	public void init(Scene scene, Pane parent, IExecutor executor){
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("../../scene/tag/TagLayout.fxml"));
			rootLayout = (AnchorPane) loader.load();
			
			rootLayout.setId("Tag"+tag.getId());
			
			
			parent.getChildren().add(rootLayout);
			
			layout = (StackPane) scene.lookup("#"+ rootLayout.getId() + " #layout");
			layout.setStyle("-fx-background-color: "+tag.getColor());
			
			name = (Text) scene.lookup("#"+ rootLayout.getId() + " #name");
			name.setStroke(Color.WHITE);
			name.setStrokeWidth(2);
			name.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
			name.setStrokeType(StrokeType.OUTSIDE);
			
			delete = (ImageView) scene.lookup("#"+ rootLayout.getId() + " #delete");
			
			name.setOnMouseReleased(new EventHandler<MouseEvent>() {
				public void handle(MouseEvent event) {
					layout.requestFocus();
				};
			});
			
			layout.focusedProperty().addListener(new ChangeListener<Boolean>() {
				@Override
				public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
					// TODO Auto-generated method stub
					if(newValue){
						layout.setStyle("-fx-border-color:black;-fx-border-width:2;-fx-background-color: "+tag.getColor());
					} else {
						layout.setStyle("-fx-background-color: "+tag.getColor());
					}
				}
			});
			
			layout.setOnKeyReleased(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent event) {
					if(event.getCode().equals(KeyCode.DELETE) && executor.execute()){
						parent.getChildren().remove(rootLayout);
					}
				}
			});
			
			delete.setOnMouseReleased(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					if(executor.execute())
						parent.getChildren().remove(rootLayout);
				}
			});
			
			name.setText(tag.getName());
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public AnchorPane getRootLayout() {
		return rootLayout;
	}

	public void setRootLayout(AnchorPane rootLayout) {
		this.rootLayout = rootLayout;
	}
}
