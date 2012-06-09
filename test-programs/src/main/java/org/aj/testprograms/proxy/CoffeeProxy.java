package org.aj.testprograms.proxy;

public class CoffeeProxy implements Coffee {

	private final Coffee proxiedCoffee;
	
	public CoffeeProxy(Coffee proxiedCoffee) {
		this.proxiedCoffee = proxiedCoffee;
	}

	@Override
	public String getName() {
		System.out.println("Proxy in play..");
		return proxiedCoffee.getName();
	}

}
