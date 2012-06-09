package org.aj.testprograms;

public class ThreadDeadlockRegular {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final Object lck1 = new Object();
		final Object lck2 = new Object();
		
		Thread t1 = new Thread() {
			@Override
			public void run() {
				System.out.println("Will wait on lck1");
				synchronized (lck1) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized (lck2) {
						System.out.println("this will never print");
					}
				}
			}
		};
		
		Thread t2 = new Thread() {
			@Override
			public void run() {
				System.out.println("Will wait on lck2");
				synchronized (lck2) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized (lck1) {
						System.out.println("this will never print");
					}
				}
			}
		};
		
		t1.start();
		t2.start();

	}

}
