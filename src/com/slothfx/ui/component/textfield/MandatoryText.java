package com.slothfx.ui.component.textfield;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.control.TextField;

public class MandatoryText {

	private TextField field;

	public MandatoryText(Node node) {
		field = (TextField) node;

		field.focusedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if (newValue) {
					field.setStyle("");
				} else {
					verify();
				}
			}
		});
	}

	public String getText() {
		return field.getText();
	}

	public boolean verify() {
		if (field.getText() == null || field.getText().length() == 0) {
			field.setStyle("-fx-control-inner-background: #FF7373");
			return false;
		}
		return true;

	}

	public TextField getField() {
		return field;
		
	}

}
