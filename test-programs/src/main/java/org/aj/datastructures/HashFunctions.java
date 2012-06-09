package org.aj.datastructures;


public class HashFunctions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String x = "Apple";
		String y = "Aplpe";
		
		int xhash = calculate_hash(x);
		int yhash = calculate_hash(y);

		System.out.println("X hash is: " + xhash);
		System.out.println("Y hash is: " + yhash);
		
		int total = 37*37*37*37*37;
		
		System.out.println("Total is: " + total);
		
		int init = 1;
		init=(init<<5)-1;
		System.out.println("Init is: " + init);
		
	}
	
	public static int calculate_hash(String input) {
	    int h = 0;
	    int len = input.length();
	    for (int i = 0; i < len; i++) {
	        h = 31 * h + input.charAt(i);
	    }
	    return h;
	}

}
