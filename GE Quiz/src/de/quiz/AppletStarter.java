package de.quiz;

import de.salocin.gameenginefx.Scheduler;
import de.salocin.gameenginefx.core.AppletGame;

/**
 * Run this class as "Java Applet"
 */
public class AppletStarter extends AppletGame {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void initPlugin() {
		Scheduler.getInstance().setState(new MainMenu());
	}
	
}
