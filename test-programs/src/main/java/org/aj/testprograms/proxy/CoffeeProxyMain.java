package org.aj.testprograms.proxy;


public class CoffeeProxyMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Coffee c = new Starbucks();
		System.out.println(c.getName());
		
		Coffee c2 = new CoffeeProxy(c);
		System.out.println(c2.getName());
		
		//dynamic proxy - specific to coffee..
		Coffee dync = CoffeeDynamicProxy.newProxyInstance(c);
		System.out.println(dync.getName());
		
		//dynamic logging proxy - any object
		Coffee y = GenericLoggingProxy.newProxyInstance(c);
		System.out.println(y.getName());
		
		
	}

}
