package de.salocin.gameenginefx.plugin;

import de.salocin.gameenginefx.util.StartArguments;

public interface CorePlugin extends Plugin {
	
	default boolean isApplet() {
		return false;
	}
	
	default String[] getStartArguments() {
		return new String[] { StartArguments.SCENE_WIDTH + "=800", StartArguments.SCENE_HEIGHT + "=800", StartArguments.CLEAR_EACH_FRAME + "=true" };
	}
}
