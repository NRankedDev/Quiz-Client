package de.quiz;

import de.quiz.engine.Scheduler;
import de.quiz.engine.core.AppletGame;

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
