package de.salocin.gameenginefx.gui;

import javafx.geometry.Rectangle2D;

public class Button extends Component {
	
	private Runnable listener;
	
	public Button() {
		super();
	}
	
	public Button(String title) {
		super(title);
	}
	
	public Button(String title, double x, double y) {
		super(title, x, y);
	}
	
	public Button(String title, Rectangle2D bounds) {
		super(title, bounds);
	}
	
	public Button(String title, double x, double y, double width, double height) {
		super(title, x, y, width, height);
	}
	
	public void setListener(Runnable listener) {
		this.listener = listener;
	}
	
}
