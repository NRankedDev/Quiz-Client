package de.salocin.gameenginefx.handler;

import javafx.scene.input.KeyEvent;

public interface KeyHandler {
	
	default void keyPressed(KeyEvent e) {
	}
	
	default void keyReleased(KeyEvent e) {
	}
	
	default void keyTyped(KeyEvent e) {
	}
	
}