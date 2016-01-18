package de.quiz.engine.core;

import de.quiz.engine.plugin.CorePlugin;
import de.quiz.engine.util.FXApplet;

public abstract class AppletGame extends FXApplet implements CorePlugin {
	
	private static final long serialVersionUID = 1L;
	private static AppletGame instance;
	
	public AppletGame() {
		instance = this;
	}
	
	public static AppletGame getInstance() {
		return instance;
	}
	
	@Override
	public final boolean isApplet() {
		return true;
	}
	
	@Override
	public CorePlugin getCorePlugin() {
		return this;
	}
	
}
