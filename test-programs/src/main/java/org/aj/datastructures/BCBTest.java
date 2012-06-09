package org.aj.datastructures;

public class BCBTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final BlockingCircularBuffer b = new BlockingCircularBuffer();
		final int streamEntries = 100;

		Thread consumer = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < streamEntries; i++) {
					System.out.println("Consumer consumed: " + b.read());
				}
			}
		});

		Thread producer = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < streamEntries; i++) {
					System.out.println("Producer wrote Object" + i);
					b.write(new String("Object" + i));
				}

			}
		});
		
		consumer.start();
		producer.start();
	}
}
