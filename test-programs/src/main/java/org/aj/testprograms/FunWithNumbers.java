package org.aj.testprograms;

public class FunWithNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		int a = -5;
//		System.out.println("A Binary: " + Integer.toBinaryString(a));
//		System.out.println("A Hex: " + Integer.toHexString(a));
//		
//		int b = a>>>2;
//		System.out.println("B is: " + b);
//		System.out.println("B Binary: " + Integer.toBinaryString(b));
//		System.out.println("B Hex: " + Integer.toHexString(b));
//	
//		int m = 78;
//		int n = 78>>2;
//		System.out.println("n is:  " + n);
		
		int c = -1;
		int d = c>>>1;
		System.out.println("C is: " + c);
		System.out.println("C Binary: " + Integer.toBinaryString(c));
		System.out.println("C Hex: " + Integer.toHexString(c));
	
		System.out.println("D is: " + d);
		System.out.println("D Binary: " + Integer.toBinaryString(d));
		System.out.println("D Hex: " + Integer.toHexString(d));
		
		// 2's complement
		int e = 87;
		System.out.println("E is: " + Integer.toBinaryString(e));
		
		// flip e by xoring with all 1s
		e ^= 0xFFFFFFFF;
		// add 1
		e += 0x00000001;
		System.out.println("E is: " + e);
		
		
		
		
	
	
	}

}
