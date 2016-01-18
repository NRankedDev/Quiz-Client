package de.salocin.gameenginefx.gui.layout;

import de.salocin.gameenginefx.gui.Component;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.Canvas;

public interface LayoutData {
	
	Rectangle2D getBounds(Canvas canvas, Component component);
	
}
