package org.aj.testprograms.proxy;

public class Starbucks implements Coffee {

	@Override
	public String getName() {
		return Starbucks.class.getCanonicalName();
	}

}
