package com.tuf.dsa.java11;

public class PrivateMethodInterfaceExampleMain {

	public static void main(String[] args) {
		
		EfficientInterfaceTennisExample tennis = new ProfessionTennisExample();
		tennis.backhand();
		EfficientInterfaceTennisExample.forehand();
		
		//tennis.hit();
		
		// Advantage 2: Improve code encapsulation
		// here we don't have hit method if we want to call.
		// hit is well encasulated to interface only and used within
		//interface only.
	}
}
