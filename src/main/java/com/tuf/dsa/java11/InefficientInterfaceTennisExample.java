package com.tuf.dsa.java11;

public interface InefficientInterfaceTennisExample {
	// Tennis Sport example

	static void forehand() {
		System.out.println("Move into position.");
		System.out.println("Hitting a forehand");
		System.out.println("Move back into ready position");

	}

	default void backhand() {
		System.out.println("Move into position.");
		System.out.println("Hitting a backhand");
		System.out.println("Move back into ready position");

	}

	default void smash() {
		System.out.println("Move into position.");
		System.out.println("Hitting a smash");
		System.out.println("Move back into ready position");

	}
}
