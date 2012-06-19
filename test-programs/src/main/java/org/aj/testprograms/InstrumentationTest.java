package org.aj.testprograms;

import java.math.BigInteger;

public class InstrumentationTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BigInteger b = new BigInteger(
				"999999999999999999999999999999999999999999999999999999");
		System.out.println("max biginteger " + b.intValue());

		int x = (1 << 16) - 1;
		System.out.println("X is: " + x);
	}

}
