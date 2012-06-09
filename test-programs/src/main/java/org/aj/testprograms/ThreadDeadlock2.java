package org.aj.testprograms;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadDeadlock2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final ExecutorService e = Executors.newSingleThreadExecutor();
		Callable<String> m = new Callable<String>() {

			@Override
			public String call() throws Exception {
				Future<String> x = e.submit(new Callable<String>() {

					@Override
					public String call() throws Exception {
						return "Anish";
					}
				});

				Future<String> y = e.submit(new Callable<String>() {

					@Override
					public String call() throws Exception {
						return "Jayavant";
					}
				});

				return x.get() + y.get();
//				return x.get();
			}
		};

		Future<String> res = e.submit(m);
		try {
			System.out.println(res.get());
		} catch (InterruptedException | ExecutionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		e.shutdown();
	}
}
