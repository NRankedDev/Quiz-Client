package de.quiz;

import de.quiz.engine.Scheduler;
import de.quiz.engine.plugin.CorePlugin;
import de.quiz.engine.plugin.PluginManager;

public class ApplicationStarter implements CorePlugin {
	
	public static void main(String[] args) {
		PluginManager.loadPlugin(ApplicationStarter.class);
	}
	
	@Override
	public void initPlugin() {
		Scheduler.getInstance().setState(new MainMenu());
	}
	
}
