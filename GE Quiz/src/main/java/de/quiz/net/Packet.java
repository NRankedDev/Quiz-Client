package de.quiz.net;

public abstract class Packet {
	
	/**
	 * Receive a packet from server
	 */
	public abstract void get();
	
	/**
	 * Send a packet to server
	 */
	public abstract void send();
	
}
