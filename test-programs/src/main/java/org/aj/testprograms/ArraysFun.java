package org.aj.testprograms;

public class ArraysFun<T> {

	T[] x;
	
	public ArraysFun(T[] ref){
		x = ref;
	}
	
	public T getFirst(){
		return x[0];
	}
	
	public int getLength(){
		return x.length;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArraysFun<String> x = new ArraysFun<>(new String[10]);
		System.out.println(x.getLength());
		
		Object[] a = new Object[10];
		Object b = a;
		System.out.println(b.getClass().getCanonicalName());
	}

}
