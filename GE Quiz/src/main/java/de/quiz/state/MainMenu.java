package de.quiz.state;

import de.salocin.gameenginefx.Scheduler;
import de.salocin.gameenginefx.gui.Button;
import de.salocin.gameenginefx.gui.layout.RelativeData;
import de.salocin.gameenginefx.render.MenuRenderState;
import de.salocin.gameenginefx.util.FXHelper;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MainMenu extends MenuRenderState {
	
	private long fps = 0;
	
	@Override
	public void init(Canvas canvas) {
		Button play = new Button("Play");
		play.setBackgroundColor(Color.RED);
		play.setListener(() -> {
			Scheduler.getInstance().setState(ConnectionScreen.INSTANCE);
		});
		
		Button options = new Button("Options");
		options.setBackgroundColor(Color.RED);
		options.setListener(() -> {
		
		});
		
		Button exit = new Button("Exit");
		exit.setBackgroundColor(Color.RED);
		exit.setListener(() -> {
			Scheduler.getInstance().shutdown(0);
		});
		
		addComponent(play, new RelativeData().top(0, 20).centeredWidth(200).height(50));
		addComponent(options, new RelativeData().top(play).centeredWidth(200).height(50));
		addComponent(exit, new RelativeData().centeredWidth(200).height(50));
	}
	
	@Override
	public void update(Canvas canvas, long delta, long fps) {
		super.update(canvas, delta, fps);
		
		this.fps = fps;
	}
	
	@Override
	public void render(Canvas canvas, GraphicsContext gc) {
		super.render(canvas, gc);
		
		gc.setFill(Color.WHITE);
		gc.setFont(new Font("Consolas", 18));
		String s = "FPS: " + fps;
		
		gc.fillText(s, 10, 10 + FXHelper.getStringHeight(gc.getFont()) / 2);
	}
	
}
