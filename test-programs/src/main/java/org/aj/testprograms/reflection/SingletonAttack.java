package org.aj.testprograms.reflection;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonAttack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//access elvis through singleton method..
		Elvis firstElvis = Elvis.getTheElvis();
		
		// play wicked game of invoking private elvis constructor
		Class<Elvis> ec = Elvis.class;
		Elvis secondElvis = null;
		try {
			Constructor<?>[] econstructors = ec.getDeclaredConstructors();
			System.out.println("Elvis has " + econstructors.length + " constructors");
			for(Constructor<?> c: econstructors){
				// wicked! set all constructors to be accessible
				System.out.println("Constructor:" + c.getName());
				c.setAccessible(true);
				secondElvis = (Elvis)c.newInstance(new Object[]{});
			}
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
