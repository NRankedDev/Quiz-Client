package de.quiz.engine.gui.layout;

import de.quiz.engine.gui.Component;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.Canvas;

public interface LayoutData {
	
	Rectangle2D getBounds(Canvas canvas, Component component);
	
}
