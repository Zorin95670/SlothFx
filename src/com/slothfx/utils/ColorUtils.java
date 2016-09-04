package com.slothfx.utils;

import javafx.scene.paint.Color;

public class ColorUtils {

	public static final String convert(Color color){
		return String.format("#%02x%02x%02x", (int)color.getRed(), (int)color.getGreen(), (int)color.getBlue());
	}
}
