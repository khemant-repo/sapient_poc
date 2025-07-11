package com.tuf.dsa.java11;
/**
 * if hit is simple private not private-static then forehand has an issue
 * This is the same as with classes (can be called as I.S. rule) - instance to static is ok
 * but not the other way around
 * 
 * Advantage 1 : Here we have lot more concise code and removed duplicate code, achieved advantage 1.
 * 
 * Advantage 2 : refer PrivateMethodInterfaceExampleMain class
 */
public interface EfficientInterfaceTennisExample {

	
	private static void hit(String stroke) {
		System.out.println("Move into position.");
		System.out.println("Hitting a " + stroke);
		System.out.println("Move back into ready position");
	}

	static void forehand() {
		hit("forehand");
	}

	default void backhand() {
		hit("backhand");
	}

	private void smash() {
		hit("smash");
	}
}
