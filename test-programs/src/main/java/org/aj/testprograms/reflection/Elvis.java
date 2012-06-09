package org.aj.testprograms.reflection;

public class Elvis {
	private static int numInstances = 0;
	private static final Elvis instance = new Elvis();
	
	private Elvis(){
		++numInstances;
		System.out.println("Elvis is born " + numInstances + " times");
	}
	
	static Elvis getTheElvis(){
		return instance;
	}
}