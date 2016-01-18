package de.quiz.engine.handler;

import java.util.HashSet;

import de.quiz.engine.core.Display;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class HandlerManager {
	
	private static final HandlerManager instance = new HandlerManager();
	private final HashSet<KeyHandler> keyHandler = new HashSet<KeyHandler>();
	private final HashSet<MouseHandler> mouseHandler = new HashSet<MouseHandler>();
	private final HashSet<ControllerHandler> controllerHandler = new HashSet<ControllerHandler>();
	private Point2D mousePos = new Point2D(0, 0);
	
	private HandlerManager() {
		if (!Display.isInitialized()) {
			throw new RuntimeException("Display not initialized!");
		}
		
		final Scene scene = Display.getInstance().getScene();
		
		scene.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
			synchronized (this) {
				for (KeyHandler kh : keyHandler) {
					kh.keyPressed(e);
				}
			}
		});
		scene.addEventHandler(KeyEvent.KEY_RELEASED, e -> {
			synchronized (this) {
				for (KeyHandler kh : keyHandler) {
					kh.keyReleased(e);
				}
			}
		});
		scene.addEventHandler(KeyEvent.KEY_TYPED, e -> {
			synchronized (this) {
				for (KeyHandler kh : keyHandler) {
					kh.keyTyped(e);
				}
			}
		});
		
		scene.addEventHandler(MouseEvent.MOUSE_MOVED, e -> {
			synchronized (this) {
				for (MouseHandler mh : mouseHandler) {
					mousePos = new Point2D(e.getX(), e.getY());
					mh.mouseMoved(e);
				}
			}
		});
		
		scene.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> {
			synchronized (this) {
				for (MouseHandler mh : mouseHandler) {
					mh.mousePressed(e);
				}
			}
		});
		
		scene.addEventHandler(MouseEvent.MOUSE_RELEASED, e -> {
			synchronized (this) {
				for (MouseHandler mh : mouseHandler) {
					mh.mouseReleased(e);
				}
			}
		});
	}
	
	public static HandlerManager getInstance() {
		return instance;
	}
	
	public synchronized Point2D getMousePosition() {
		return mousePos;
	}
	
	public synchronized void addKeyHandler(KeyHandler handler) {
		keyHandler.add(handler);
	}
	
	public synchronized boolean isKeyHandlerRegistered(KeyHandler handler) {
		return keyHandler.contains(handler);
	}
	
	public synchronized HashSet<KeyHandler> getKeyHandler() {
		return keyHandler;
	}
	
	public synchronized void addMouseHandler(MouseHandler handler) {
		mouseHandler.add(handler);
	}
	
	public synchronized boolean isMouseHandlerRegistered(KeyHandler handler) {
		return mouseHandler.contains(handler);
	}
	
	public synchronized HashSet<MouseHandler> getMouseHandler() {
		return mouseHandler;
	}
	
	public synchronized void addControllerHandler(ControllerHandler handler) {
		controllerHandler.add(handler);
	}
	
	public synchronized boolean isControllerHandlerRegistered(KeyHandler handler) {
		return controllerHandler.contains(handler);
	}
	
	public synchronized HashSet<ControllerHandler> getControllerHandler() {
		return controllerHandler;
	}
	
	//	public synchronized ControllerManager getControllerManager() {
	//		return controllerManager;
	//	}
	
}
