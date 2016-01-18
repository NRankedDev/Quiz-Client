package de.salocin.gameenginefx.core;

import de.salocin.gameenginefx.Scheduler;
import de.salocin.gameenginefx.plugin.CorePlugin;
import de.salocin.gameenginefx.plugin.PluginManager;
import de.salocin.gameenginefx.render.MenuRenderState;
import de.salocin.gameenginefx.render.RenderState;
import de.salocin.gameenginefx.util.ResizableCanvas;
import de.salocin.gameenginefx.util.StartArguments;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Display {
	
	private static Display instance;
	private static boolean initialized = false;
	private ResizableCanvas canvas = new ResizableCanvas();
	private Scene scene;
	
	public Display() throws Exception {
		if (instance != null) {
			throw new IllegalAccessException("Use the getInstance method");
		}
		
		instance = this;
	}
	
	public static Display getInstance() {
		return instance;
	}
	
	public static boolean isInitialized() {
		return initialized;
	}
	
	public static void initApplet(CorePlugin corePlugin) throws Exception {
		Display d = new Display();
		BorderPane root = new BorderPane();
		
		StartArguments.reinit(corePlugin.getStartArguments());
		
		d.init(new Scene(root), root);
		corePlugin.initPlugin();
	}
	
	public static void initApplication(CorePlugin corePlugin, Stage stage) throws Exception {
		Display d = new Display();
		BorderPane root = new BorderPane();
		
		StartArguments.reinit(corePlugin.getStartArguments());
		
		d.init(new Scene(root, StartArguments.getDouble("engine:width", 800), StartArguments.getDouble("engine:height", 600)), root);
	}
	
	private void init(Scene scene, Pane root) throws Exception {
		if (!scene.getRoot().equals(root)) {
			throw new IllegalArgumentException("scene.getRoot() != root");
		}
		
		this.scene = scene;
		
		root.getChildren().add(canvas);
		
		canvas.widthProperty().bind(root.widthProperty());
		canvas.heightProperty().bind(root.heightProperty());
		
		CanvasSizeChange listener = new CanvasSizeChange();
		
		canvas.widthProperty().addListener(listener);
		canvas.heightProperty().addListener(listener);
		
		Scheduler.getInstance();
		PluginManager.getInstance();
		
		initialized = true;
	}
	
	public Scene getScene() {
		return scene;
	}
	
	public ResizableCanvas getCanvas() {
		return canvas;
	}
	
	private class CanvasSizeChange implements ChangeListener<Number> {
		@Override
		public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
			RenderState state = Scheduler.getInstance().getState();
			
			if (state != null && MenuRenderState.class.isAssignableFrom(state.getClass())) {
				((MenuRenderState) state).getMenu().pack();
			}
		}
	}
	
}
