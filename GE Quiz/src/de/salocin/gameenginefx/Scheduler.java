package de.salocin.gameenginefx;

import de.salocin.gameenginefx.core.Display;
import de.salocin.gameenginefx.render.RenderState;
import de.salocin.gameenginefx.util.StartArguments;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Scheduler {
	
	private static final Scheduler instance = new Scheduler();
	private final AnimationTimer loop;
	private Canvas canvas;
	private GraphicsContext gc;
	private RenderState state;
	
	private Scheduler() {
		loop = new AnimationTimer() {
			private long last;
			private long fpsDetectStart;
			private int fpsCount;
			private int fps;
			
			@Override
			public void handle(long now) {
				if (state != null && Display.isInitialized()) {
					long delta = now - last;
					last = now;
					
					countFps(now);
					
					synchronized (Scheduler.this) {
						if (StartArguments.getBoolean(StartArguments.CLEAR_EACH_FRAME)) {
							gc.setFill(Color.BLACK);
							gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
						}
						
						state.update(canvas, delta, fps);
						state.render(canvas, gc);
					}
				}
			}
			
			private void countFps(long now) {
				if (fpsDetectStart == 0) {
					fpsDetectStart = now;
				}
				
				if (now - fpsDetectStart >= Math.pow(10, 9)) {
					fpsDetectStart = now;
					fps = fpsCount;
					fpsCount = 0;
				} else {
					fpsCount++;
				}
			}
		};
		
		loop.start();
	}
	
	public static Scheduler getInstance() {
		return instance;
	}
	
	public synchronized void shutdown() {
		loop.stop();
	}
	
	public synchronized void setState(RenderState state) {
		this.canvas = Display.getInstance().getCanvas();
		this.gc = canvas.getGraphicsContext2D();
		this.state = state;
		state.init(Display.getInstance().getCanvas());
		
		// Clearing old state
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
	}
	
	public synchronized RenderState getState() {
		return state;
	}
	
}
