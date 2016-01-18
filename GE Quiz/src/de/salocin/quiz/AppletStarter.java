package de.salocin.quiz;

import de.salocin.gameenginefx.Scheduler;
import de.salocin.gameenginefx.core.AppletGame;

public class AppletStarter extends AppletGame {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void initPlugin() {
		Scheduler.getInstance().setState(new MainMenu());
	}
	
}
