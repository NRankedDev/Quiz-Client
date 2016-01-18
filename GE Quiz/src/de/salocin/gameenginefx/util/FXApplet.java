package de.salocin.gameenginefx.util;

import javax.swing.JApplet;
import javax.swing.SwingUtilities;

import de.salocin.gameenginefx.core.Display;
import de.salocin.gameenginefx.plugin.CorePlugin;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;

public abstract class FXApplet extends JApplet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() {
		setIgnoreRepaint(true);
		SwingUtilities.invokeLater(() -> {
			initSwing();
		});
	}
	
	private void initSwing() {
		final JFXPanel panel = new JFXPanel();
		add(panel);
		
		Platform.runLater(() -> {
			initFX(panel);
		});
	}
	
	private void initFX(JFXPanel panel) {
		try {
			Display.initApplet(getCorePlugin());
			panel.setScene(Display.getInstance().getScene());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public abstract CorePlugin getCorePlugin();
	
}
