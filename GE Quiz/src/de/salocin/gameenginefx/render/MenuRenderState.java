package de.salocin.gameenginefx.render;

import de.salocin.gameenginefx.gui.Component;
import de.salocin.gameenginefx.gui.Menu;
import de.salocin.gameenginefx.gui.layout.LayoutData;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public abstract class MenuRenderState implements RenderState {
	
	private final Menu menu = new Menu();
	
	public void addComponents(Component... components) {
		for (Component component : components) {
			addComponent(component);
		}
	}
	
	public void addComponent(Component component) {
		menu.add(component);
	}
	
	public void addComponent(Component component, LayoutData attachment) {
		menu.add(component, attachment);
	}
	
	public void updateComponents(Canvas canvas) {
		for (Component component : menu.getComponents()) {
			component.update(canvas);
		}
	}
	
	public void renderComponents(Canvas canvas, GraphicsContext gc) {
		for (Component component : menu.getComponents()) {
			component.render(canvas, gc);
		}
	}
	
	public Menu getMenu() {
		return menu;
	}
	
	@Override
	public void init(Canvas canvas) {
	}
	
	@Override
	public void update(Canvas canvas, long delta, long fps) {
		updateComponents(canvas);
	}
	
	@Override
	public void render(Canvas canvas, GraphicsContext gc) {
		renderComponents(canvas, gc);
	}
	
}
