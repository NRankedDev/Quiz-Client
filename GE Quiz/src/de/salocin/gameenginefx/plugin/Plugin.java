package de.salocin.gameenginefx.plugin;

public interface Plugin {
	
	default String getName() {
		return getClass().getSimpleName();
	}
	
	void initPlugin();
	
}
