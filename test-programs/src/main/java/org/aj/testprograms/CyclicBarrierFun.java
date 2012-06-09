package org.aj.testprograms;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierFun {

	private static ThreadLocal<SimpleDateFormat> sdf = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
		}

	};

	private static class Worker implements Runnable {

		private final CyclicBarrier c;
		
		Worker(CyclicBarrier c) {
			this.c = c;
		}


		@Override
		public void run() {
			System.out.println("Now doing work in "
					+ Thread.currentThread().getName() + " at time: "
					+ sdf.get().format(new Date()));
			try {
				// do some work
				//now await completion of other threads
				c.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			System.out.println("Finished work in "
//					+ Thread.currentThread().getName() + " at time: "
//					+ sdf.get().format(new Date()));
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Worker[] workers = new Worker[3];
		
		CyclicBarrier m = new CyclicBarrier(workers.length, new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Doing clean up work in "
						+ Thread.currentThread().getName() + " at time: "
						+ sdf.get().format(new Date()));
			}
		});

		for(int i=0;i<workers.length;i++){
			workers[i] = new Worker(m);
			new Thread(workers[i]).start();
		}

	}

}
