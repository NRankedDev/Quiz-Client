package de.quiz.engine.plugin;

import java.util.HashSet;

import de.quiz.engine.core.ApplicationGame;
import de.quiz.engine.core.Display;

public class PluginManager {
	
	private static final PluginManager instance = new PluginManager();
	private HashSet<Plugin> plugins = new HashSet<Plugin>();
	private CorePlugin corePlugin;
	
	private PluginManager() {
	}
	
	public static PluginManager getInstance() {
		return instance;
	}
	
	public static <T extends Plugin> T loadPlugin(Class<T> pluginClass) {
		return getInstance().load(pluginClass);
	}
	
	public <T extends Plugin> T load(Class<T> pluginClass) {
		for (Plugin plugin : plugins) {
			if (CorePlugin.class.isAssignableFrom(pluginClass) && CorePlugin.class.isAssignableFrom(plugin.getClass())) {
				throw new IllegalArgumentException("There is already a Core Plugin registered. Extend the 'ExternalPlugin' class instead.");
			} else if (plugin.getClass().equals(pluginClass)) {
				throw new IllegalArgumentException("Plugin already registered");
			}
		}
		
		try {
			T plugin = pluginClass.newInstance();
			
			if (CorePlugin.class.isAssignableFrom(pluginClass)) {
				corePlugin = (CorePlugin) plugin;
				
				if (!corePlugin.isApplet() && !Display.isInitialized()) {
					new Thread(() -> {
						while (!Display.isInitialized()) {
							try {
								Thread.sleep(10);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
						
						// Locking the thread until display is initialized
						// Then init the Core Plugin
						
						corePlugin.initPlugin();
					}).start();
					
					ApplicationGame.launch(corePlugin);
				}
				
				return null;
			} else {
				plugins.add(plugin);
				plugin.initPlugin();
				
				return plugin;
			}
		} catch (InstantiationException | IllegalAccessException e) {
			throw new IllegalArgumentException("The plugin has to have an empty constructor which must be public.", e);
		}
	}
	
	public HashSet<Plugin> getPlugins() {
		return plugins;
	}
	
	public CorePlugin getCorePlugin() {
		return corePlugin;
	}
	
}
