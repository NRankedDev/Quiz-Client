package de.salocin.gameenginefx.handler;

public enum ControllerDirectionPad {
	
	NORTH,
	NORTH_EAST,
	EAST,
	SOUTH_EAST,
	SOUTH,
	SOUTH_WEST,
	WEST,
	NORTH_WEST;
	
	public int getDirection() {
		return ordinal();
	}
	
	public static ControllerDirectionPad valueOf(int direction) {
		for (ControllerDirectionPad pad : values()) {
			if (pad.getDirection() == direction) {
				return pad;
			}
		}
		
		return null;
	}
	
}