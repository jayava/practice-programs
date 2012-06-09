package org.aj.testprograms.generics;

import java.util.LinkedList;
import java.util.List;

public class FunWithGenerics {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> strList = new LinkedList<String>();
		strList.add("Anish");
		strList.add("Andy");
		
		Object[] objs = strList.toArray();
		for(Object o: objs){
			System.out.println("A bad thing is about to happen");
			System.err.println((Integer)o);
		}
//		
//		String[] x = new String[10];
//		addToArray(x);
//		for(String y : x){
//			System.out.println("String: " + y);
//		}
	}
	
	private static void addToArray(String[] args){
		for(int i=0;i<args.length;i++){
			args[i] = "String" + i;
		}
		
		args = new String[15];
	}

}
