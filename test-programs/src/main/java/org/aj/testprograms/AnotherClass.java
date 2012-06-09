package org.aj.testprograms;

public class AnotherClass {

	public static void main(String[] args) {
		int a = 2;
		int b = 3;
		
		a = a^b;
		b = a^b; // ( a^b ^b = a^0 = a )
		a = a^b; // ( a = a^b^a = a)
		
		System.out.println(a);
		System.out.println(b);
	}
}
