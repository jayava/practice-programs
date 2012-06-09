package org.aj.testprograms.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class GenericLoggingProxy implements InvocationHandler {

	private final Object proxiedObj;
	
	private GenericLoggingProxy(Object proxiedObj) {
		this.proxiedObj = proxiedObj;
	}

	@SuppressWarnings("unchecked")
	/**
	 * 
	 * @param obj
	 * @return the casted object T
	 * 
	 * This is a safe-cast as we will be passing
	 * in only a "T" object into the method
	 */
	public static <T extends Object> T newProxyInstance(T obj){
		return (T)Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), 
				new GenericLoggingProxy(obj));
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("Method to be invoked: " + method.getName());
		return method.invoke(proxiedObj, args);
	}

}
