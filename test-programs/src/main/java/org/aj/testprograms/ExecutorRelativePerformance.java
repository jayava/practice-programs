package org.aj.testprograms;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

public class ExecutorRelativePerformance {

	private static final int TASKS = 100;
	private static final int THREADS = 2;

	/**
	 * @param args
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public static void main(String[] args) throws InterruptedException,
			ExecutionException {
		ExecutorService service1 = Executors.newCachedThreadPool();
		ExecutorService service2 = Executors.newSingleThreadExecutor();
		ExecutorService service3 = Executors.newFixedThreadPool(THREADS);
		
		List<Callable<String>> tasklist = new LinkedList<Callable<String>>();
		final AtomicLong idGen = new AtomicLong();

		// create lots of tasks
		for (int i = 0; i < TASKS; i++) {
			tasklist.add(new Callable<String>() {

				@Override
				public String call() throws Exception {
//					System.out.println("Executing task in thread: "
//							+ Thread.currentThread().getName());
					return "Anish" + idGen.incrementAndGet();
				}
			});
		}
		long startTime = System.nanoTime();
		service1.invokeAll(tasklist);
		long timeElapsed = System.nanoTime() - startTime;
		System.out.println("#################CACHED THREAD POOL#########################");
		System.out.println("Execution time: " + timeElapsed + " nanos");
		
		startTime = System.nanoTime();
		service2.invokeAll(tasklist);
		timeElapsed = System.nanoTime() - startTime;
		System.out.println("#################SINGLE THREADED POOL#########################");
		System.out.println("Execution time: " + timeElapsed + " nanos");
		
		startTime = System.nanoTime();
		service3.invokeAll(tasklist);
		timeElapsed = System.nanoTime() - startTime;
		System.out.println("#################BOUNDED THREAD POOL#########################");
		System.out.println("Threads: " + THREADS);
		System.out.println("Execution time: " + timeElapsed + " nanos");

		service1.shutdown();
		service2.shutdown();
		service3.shutdown();
	}
}
