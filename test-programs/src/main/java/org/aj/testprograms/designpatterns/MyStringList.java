package org.aj.testprograms.designpatterns;

import java.util.ArrayList;
import java.util.List;

public class MyStringList {

	private final List<String> l;
	
	private MyStringList(){
		l = new ArrayList<>();
	}
	
	private MyStringList(int capacity){
		l = new ArrayList<>(capacity);
	}
	
	public static MyStringList defaultList(){
		return new MyStringList();
	}
	
	public static MyStringList listWithCap(int cap){
		return new MyStringList(cap);
	}
	
	public static void main(String[] args) {
		MyStringList m = MyStringList.defaultList();
	}
}
