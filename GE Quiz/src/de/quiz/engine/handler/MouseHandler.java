package de.quiz.engine.handler;

import javafx.scene.input.MouseEvent;

public interface MouseHandler {
	
	default void mouseMoved(MouseEvent e) {
	}
	
	default void mousePressed(MouseEvent e) {
	}
	
	default void mouseReleased(MouseEvent e) {
	}
	
}