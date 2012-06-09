package org.aj.datastructures;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SingletonPattern {
	// Singleton instance
	private static volatile SingletonPattern instance;

	private static Lock singletonLock = new ReentrantLock();

	// data members
	private final int x;

	private SingletonPattern() {
		x = 10;
	}

	public int getInstanceId() {
		return x;
	}

	public static SingletonPattern getInstance() {
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// check the value of the volatile variable
		if (instance == null) {
			// lock 
			singletonLock.lock();
			//check again 
			if (instance == null)
				instance = new SingletonPattern();
			singletonLock.unlock();
		}

		return instance;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Test the unsafe singleton pattern above
		Runnable a = new Runnable() {

			@Override
			public void run() {
				SingletonPattern x = SingletonPattern.getInstance();
				System.out.println("ThreadId: "
						+ Thread.currentThread().getName() + " InstanceId: "
						+ x);

			}
		};

		Runnable b = new Runnable() {

			@Override
			public void run() {
				SingletonPattern x = SingletonPattern.getInstance();
				System.out.println("ThreadId: "
						+ Thread.currentThread().getName() + " InstanceId: "
						+ x);
			}
		};

		Thread t1 = new Thread(a);
		Thread t2 = new Thread(b);

		t1.start();
		t2.start();

	}

}
