package de.quiz.state;

import de.salocin.gameenginefx.render.MenuRenderState;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class ConnectionScreen extends MenuRenderState {
	
	public static final ConnectionScreen INSTANCE = new ConnectionScreen();
	
	private String title;
	
	@Override
	public void init(Canvas canvas) {
	}
	
	@Override
	public void update(Canvas canvas, long delta, long fps) {
		// TODO Auto-generated method stub
		super.update(canvas, delta, fps);
	}
	
	@Override
	public void render(Canvas canvas, GraphicsContext gc) {
		// TODO Auto-generated method stub
		super.render(canvas, gc);
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
}
