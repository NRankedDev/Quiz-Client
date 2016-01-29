package de.quiz.state;

import de.quiz.net.ConnectPacket;
import de.salocin.gameenginefx.Scheduler;
import de.salocin.gameenginefx.render.MenuRenderState;
import de.salocin.gameenginefx.util.FXHelper;
import javafx.geometry.Dimension2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class ConnectionScreen extends MenuRenderState {
	
	public static final ConnectionScreen INSTANCE = new ConnectionScreen();
	
	private String title;
	
	@Override
	public void init(Canvas canvas) {
		new ConnectPacket().send();
		title = "Searching for a server...";
	}
	
	@Override
	public void update(Canvas canvas, long delta, long fps) {
		super.update(canvas, delta, fps);
		
		Scheduler.getInstance().setState(InGame.INSTANCE);
	}
	
	@Override
	public void render(Canvas canvas, GraphicsContext gc) {
		Dimension2D bounds = FXHelper.getStringSize(gc.getFont(), title);
		gc.setFill(Color.WHITE);
		gc.fillText(title, canvas.getWidth() / 2 - bounds.getWidth() / 2, canvas.getHeight() / 2 - bounds.getHeight() / 4);
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
}
