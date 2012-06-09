package org.aj.testprograms;

public class RuntimeFun {

	int test;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(Runtime.getRuntime().freeMemory());
		int cores = Runtime.getRuntime().availableProcessors();
		System.out.println("Available cores: " + cores);
	}

}
