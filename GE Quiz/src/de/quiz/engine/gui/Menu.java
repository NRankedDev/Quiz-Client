package de.quiz.engine.gui;

import java.util.HashSet;

import de.quiz.engine.gui.layout.LayoutData;

public class Menu {
	
	private HashSet<Component> components = new HashSet<Component>();
	
	public HashSet<Component> getComponents() {
		return components;
	}
	
	public void add(Component component) {
		add(component, component.getLayoutData());
	}
	
	public void add(Component component, LayoutData layoutData) {
		component.setLayoutData(layoutData);
		components.add(component);
		component.pack();
	}
	
	public void pack() {
		for (Component component : components) {
			component.pack();
		}
	}
}
