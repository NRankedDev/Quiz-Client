package de.salocin.gameenginefx.core;

import de.salocin.gameenginefx.plugin.CorePlugin;
import javafx.application.Application;
import javafx.stage.Stage;

public final class ApplicationGame extends Application {
	
	private static ApplicationGame instance;
	private static CorePlugin corePlugin;
	
	public ApplicationGame() {
		instance = this;
	}
	
	public static ApplicationGame getInstance() {
		return instance;
	}
	
	public static void launch(CorePlugin corePlugin) {
		ApplicationGame.corePlugin = corePlugin;
		launch(corePlugin.getStartArguments());
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		Display.initApplication(corePlugin, stage);
		stage.setScene(Display.getInstance().getScene());
		stage.setTitle(corePlugin.getName());
		stage.show();
	}
	
}
