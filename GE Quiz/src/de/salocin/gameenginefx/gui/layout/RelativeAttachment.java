package de.salocin.gameenginefx.gui.layout;

public class RelativeAttachment implements LayoutAttachment {
	
	public double percentage;
	public double offset;
	
	public RelativeAttachment() {
		this(50.0);
	}
	
	public RelativeAttachment(double percentage) {
		this(percentage, 0.0);
	}
	
	public RelativeAttachment(double percentage, double offset) {
		this.percentage = percentage;
		this.offset = offset;
	}
	
	@Override
	protected RelativeAttachment clone() {
		return new RelativeAttachment(percentage, offset);
	}
	
}
