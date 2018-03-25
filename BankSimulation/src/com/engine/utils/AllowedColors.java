package com.engine.utils;

import java.awt.Color;

public enum AllowedColors {
	
	YELLOW(Color.yellow),
	GREEN(Color.green),
	ORANGE(Color.orange),
	RED(Color.red),
	BlUE(Color.blue),
	DARK_GREEN(new Color(113, 140, 33)),
	CYAN(Color.cyan);
	
	private Color c;
	
	AllowedColors(Color c) {
		this.c = c;
	}
	
	public Color getColor() {
		return c;
	}
	
	public static Color getColorByName(String name) {
		for (AllowedColors c : AllowedColors.values())
			if (c.name().equalsIgnoreCase(name))
				return c.getColor();
		return null;
	}
	
}