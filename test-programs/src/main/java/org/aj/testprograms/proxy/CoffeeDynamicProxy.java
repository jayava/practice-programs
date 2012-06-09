package org.aj.testprograms.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CoffeeDynamicProxy implements InvocationHandler {

	private final Coffee proxiedCoffee;

	private CoffeeDynamicProxy(Coffee proxiedCoffee) {
		this.proxiedCoffee = proxiedCoffee;
	}

	public static Coffee newProxyInstance(Coffee proxiedCoffee) {
		return (Coffee) Proxy.newProxyInstance(Coffee.class
				.getClassLoader(), proxiedCoffee.getClass().getInterfaces(),
				new CoffeeDynamicProxy(proxiedCoffee));
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("Dynamic proxy at play..");
		return method.invoke(proxiedCoffee, args);
	}

}
