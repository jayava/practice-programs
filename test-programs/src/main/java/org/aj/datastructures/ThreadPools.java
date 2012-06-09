package org.aj.datastructures;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPools {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final CountDownLatch c = new CountDownLatch(2);
		Callable<String> m = new Callable<String>() {

			@Override
			public String call() throws Exception {
				c.await();
				System.out.println(Thread.currentThread().getName()
						+ " running for f1 task");
				return "Anish";
			}
		};

		Callable<String> m2 = new Callable<String>() {

			@Override
			public String call() throws Exception {
				c.await();
				System.out.println(Thread.currentThread().getName()
						+ " running for f2 task");
				return "AJ";
			}
		};

		ExecutorService e = Executors.newFixedThreadPool(4);

		final Future<String> f1 = e.submit(m);
		final Future<String> f2 = e.submit(m2);

		// spawn 2 threads to print results
		e.execute(new Runnable() {

			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName()
						+ " running for printing f1 task result");
				try {
					System.out.println("Thread "
							+ Thread.currentThread().getName() + "  result: "
							+ f1.get());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		e.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName()
						+ " running for printing f2 task result");
				try {
					System.out.println("Thread "
							+ Thread.currentThread().getName() + "  result: "
							+ f2.get());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		c.countDown();
		c.countDown();

		e.shutdown();
	}

}
