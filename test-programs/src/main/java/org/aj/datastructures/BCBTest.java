package org.aj.datastructures;

public class BCBTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final BlockingCircularBuffer<String> b = new BlockingCircularBuffer<>();
		final int streamEntries = 100;

		Thread consumer = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < streamEntries; i++) {
					try {
						System.out.println("Consumer consumed: " + b.read());
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}
				}
			}
		});

		Thread producer = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < streamEntries; i++) {
					System.out.println("Producer wrote Object" + i);
					try {
						b.write(new String("Object" + i));
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}
				}

			}
		});
		
		consumer.start();
		producer.start();
	}
}
