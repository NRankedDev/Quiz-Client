package de.salocin.quiz;

import de.salocin.gameenginefx.Scheduler;
import de.salocin.gameenginefx.plugin.CorePlugin;
import de.salocin.gameenginefx.plugin.PluginManager;

public class ApplicationStarter implements CorePlugin {
	
	public static void main(String[] args) {
		PluginManager.loadPlugin(ApplicationStarter.class);
	}
	
	@Override
	public void initPlugin() {
		Scheduler.getInstance().setState(new MainMenu());
	}
	
}
