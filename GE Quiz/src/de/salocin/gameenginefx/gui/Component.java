package de.salocin.gameenginefx.gui;

import de.salocin.gameenginefx.core.Display;
import de.salocin.gameenginefx.gui.layout.LayoutData;
import de.salocin.gameenginefx.handler.HandlerManager;
import de.salocin.gameenginefx.util.FXHelper;
import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

public class Component {
	
	/* Eigenschaften */
	private Rectangle2D bounds;
	private LayoutData layoutData = null;
	private String title;
	private Font titleFont;
	private Color titleColor;
	private Image backgroundImage;
	private Image backgroundHoverImage;
	private Color backgroundColor;
	private Color backgroundHoverColor;
	
	/* Temp */
	private boolean hover;
	
	public Component() {
		this(null);
	}
	
	public Component(String title) {
		this(title, 0, 0);
	}
	
	public Component(String title, double x, double y) {
		this(title, x, y, 0, 0);
	}
	
	public Component(String title, double x, double y, double width, double height) {
		this(title, new Rectangle2D(x, y, width, height));
	}
	
	public Component(String title, Rectangle2D bounds) {
		setTitle(title);
		setBounds(bounds);
	}
	
	public void setBounds(Rectangle2D bounds) {
		this.bounds = bounds == null ? new Rectangle2D(0, 0, 0, 0) : bounds;
	}
	
	public Rectangle2D getBounds() {
		return bounds;
	}
	
	public void setLayoutData(LayoutData layoutData) {
		this.layoutData = layoutData;
	}
	
	public LayoutData getLayoutData() {
		return layoutData;
	}
	
	public void pack() {
		setBounds(layoutData.getBounds(Display.getInstance().getCanvas(), this));
	}
	
	public void setTitle(String title) {
		this.title = title == null ? "" : title;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitleFont(Font titleFont) {
		this.titleFont = titleFont;
	}
	
	public Font getTitleFont() {
		return titleFont;
	}
	
	public void setTitleColor(Color titleColor) {
		this.titleColor = titleColor;
	}
	
	public Color getTitleColor() {
		return titleColor;
	}
	
	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	
	public Color getBackgroundColor() {
		return backgroundColor;
	}
	
	public void setBackgroundImage(Image backgroundImage) {
		this.backgroundImage = backgroundImage;
	}
	
	public Image getBackgroundImage() {
		return backgroundImage;
	}
	
	public void setBackgroundHoverColor(Color backgroundHoverColor) {
		this.backgroundHoverColor = backgroundHoverColor;
	}
	
	public Color getBackgroundHoverColor() {
		return backgroundHoverColor;
	}
	
	public void setBackgroundHoverImage(Image backgroundHoverImage) {
		this.backgroundHoverImage = backgroundHoverImage;
	}
	
	public Image getBackgroundHoverImage() {
		return backgroundHoverImage;
	}
	
	public void update(Canvas canvas) {
		Point2D mouse = HandlerManager.getInstance().getMousePosition();
		
		hover = bounds.contains(mouse);
	}
	
	public void render(Canvas canvas, GraphicsContext gc) {
		Font f = gc.getFont();
		
		if (titleFont != null) {
			f = titleFont;
		}
		
		Dimension2D dim = FXHelper.getStringSize(f, title);
		
		renderBackground(gc, bounds.getMinX(), bounds.getMinY(), bounds.getWidth(), bounds.getHeight());
		renderTitle(gc, bounds.getMinX() + (bounds.getWidth() - dim.getWidth()) / 2, bounds.getMinY() + bounds.getHeight() / 2 + dim.getHeight() / 4);
	}
	
	protected void renderTitle(GraphicsContext gc, double x, double y) {
		if (title != null) {
			Font oldFont = gc.getFont();
			Paint oldFill = gc.getFill();
			
			if (titleFont != null) {
				gc.setFont(titleFont);
			}
			
			if (titleColor != null) {
				gc.setFill(titleColor);
			}
			
			gc.fillText(title, x, y);
			
			gc.setFont(oldFont);
			gc.setFill(oldFill);
		}
	}
	
	protected void renderBackground(GraphicsContext gc, double x, double y, double width, double height) {
		Image img = null;
		Paint oldFill = gc.getFill();
		Paint fill = oldFill;
		
		if (hover) {
			if (backgroundHoverImage != null) {
				img = backgroundHoverImage;
			} else {
				fill = backgroundHoverColor;
			}
		} else {
			if (backgroundImage != null) {
				img = backgroundImage;
			} else {
				fill = backgroundColor;
			}
		}
		
		if (img != null) {
			gc.drawImage(img, x, y, width, height);
		} else {
			gc.setFill(fill);
			gc.fillRect(x, y, width, height);
		}
		
		gc.setFill(oldFill);
	}
	
}
