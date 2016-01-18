package de.quiz.engine.plugin;

public interface Plugin {
	
	default String getName() {
		return getClass().getSimpleName();
	}
	
	void initPlugin();
	
}
