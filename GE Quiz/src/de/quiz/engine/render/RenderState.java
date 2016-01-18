package de.quiz.engine.render;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public interface RenderState {
	
	void init(Canvas canvas);
	
	void update(Canvas canvas, long delta, long fps);
	
	void render(Canvas canvas, GraphicsContext gc);
	
}
