package de.quiz.engine.util;

import java.util.HashMap;

public class StartArguments {
	
	private static final String enginePrefix = "engine:";
	
	public static final String SCENE_WIDTH = enginePrefix + "sceneWidth";
	public static final String SCENE_HEIGHT = enginePrefix + "sceneHeight";
	public static final String CLEAR_EACH_FRAME = enginePrefix + "clearEachFrame";
	
	private static final HashMap<String, Object> args = new HashMap<String, Object>();
	private static String[] raw;
	
	public static void reinit(String[] args) {
		raw = args;
		
		parse(args);
	}
	
	private static void parse(String[] args) {
		for (String arg : args) {
			if (arg.contains("=")) {
				String[] parts = arg.split("=");
				
				StartArguments.args.put(parts[0], parts[1]);
			}
		}
	}
	
	public static String[] getArguments() {
		return raw;
	}
	
	public static void set(String key, Object value) {
		args.put(key, value);
	}
	
	public static Object get(String key) {
		return get(key, null);
	}
	
	public static Object get(String key, Object def) {
		if (args.containsKey(key)) {
			return args.get(key);
		} else {
			return def;
		}
	}
	
	public static String getString(String key) {
		return getString(key, null);
	}
	
	public static String getString(String key, String def) {
		return get(key, def).toString();
	}
	
	public static int getInteger(String key) {
		return getInteger(key, -1);
	}
	
	public static int getInteger(String key, int def) {
		try {
			return Integer.parseInt(getString(key, String.valueOf(def)));
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return def;
		}
	}
	
	public static double getDouble(String key) {
		return getDouble(key, -1.0);
	}
	
	public static double getDouble(String key, double def) {
		try {
			return Double.parseDouble(getString(key, String.valueOf(def)));
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return def;
		}
	}
	
	public static boolean getBoolean(String key) {
		return getBoolean(key, false);
	}
	
	public static boolean getBoolean(String key, boolean def) {
		return Boolean.parseBoolean(getString(key, String.valueOf(def)));
	}
	
}
