package org.aj.testprograms;

public class XORSwap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int x = -29;
		int y = -11;
		
		System.out.println("X is: " + x + " Y is: " + y);
		
		//Step 1: X  = X XOR Y
		x = x^y;
		//Step 2: Y = (X XOR Y ) XOR Y =  X
		y = x^y;
		//Step 3: X = (X XOR Y) XOR X = Y
		x = x^y;
		
		System.out.println("X is: " + x + " Y is: " + y);
		
	}

}
