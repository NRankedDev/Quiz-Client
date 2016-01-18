package de.quiz.engine.util;

import com.sun.javafx.tk.FontMetrics;
import com.sun.javafx.tk.Toolkit;

import javafx.geometry.Dimension2D;
import javafx.scene.text.Font;

public class FXHelper {
	
	public static Dimension2D getStringSize(Font font, String string) {
		FontMetrics metrics = Toolkit.getToolkit().getFontLoader().getFontMetrics(font);
		return new Dimension2D(metrics.computeStringWidth(string), metrics.getLineHeight());
	}
	
	public static double getStringWidth(Font font, String string) {
		return getStringSize(font, string).getWidth();
	}
	
	public static double getStringHeight(Font font, String string) {
		return getStringSize(font, string).getHeight();
	}
	
}