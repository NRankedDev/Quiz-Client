package de.salocin.gameenginefx.handler;

public interface ControllerHandler {
	
	default void controllerButtonPressed(ControllerButton button) {
	}
	
	default void controllerButtonReleased(ControllerButton button) {
	}
	
	/**
	 * @param magnitude
	 *            0..1
	 */
	default void controllerLeftTrigger(double magnitude) {
	}
	
	/**
	 * @param magnitude
	 *            0..1
	 */
	default void controllerRightTrigger(double magnitude) {
	}
	
	/**
	 * @param direction
	 *            In Grad: 0..360
	 * @param magnitude
	 *            0..1
	 */
	default void controllerLeftStickMoved(double direction, double magnitude) {
	}
	
	/**
	 * @param direction
	 *            In Grad: 0..360
	 * @param magnitude
	 *            0..1
	 */
	default void controllerRightStickMoved(double direction, double magnitude) {
	}
	
	default void controllerDpadPressed(ControllerDirectionPad direction) {
	}
	
	default void controllerDpadReleased(ControllerDirectionPad direction) {
	}
	
}