package org.aj.testprograms;


public class ClassLoaderFun {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassLoader cl = ClassLoaderFun.class.getClassLoader();
		System.out.println("Class Loader: " + cl.getClass().getCanonicalName());
	}

}
