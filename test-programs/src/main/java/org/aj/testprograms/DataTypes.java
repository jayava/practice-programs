package org.aj.testprograms;

import java.util.BitSet;

public class DataTypes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String x = "Anish";
		System.out.println(x.substring(4));
		// 
		BitSet a = new BitSet(8);
		a.clear();
		System.out.println("Bit set size: " + a.size());
		a.set(9, true);
		System.out.println("Bit set: " + a);
		
		int maxInt = (1<<31) - 1;
		int minInt = -2147483648;
		
		System.out.println("Max int: " + maxInt);
		System.out.println("Min int: " + minInt);
	}

}
