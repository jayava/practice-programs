package org.aj.testprograms;

public class MergeSort {

	/**
	 * sorts the array of numbers using the basic Merge Sort algorithm
	 * 
	 * @param numbers
	 */
	public static void sort(int[] numbers) {
		if (numbers.length <= 1)
			return;

		mergesort(0, numbers.length - 1, numbers);
	}

	/**
	 * 
	 * @param low
	 * @param high
	 */
	private static void mergesort(int low, int high, int[] numbers) {
		if (low < high) {
			int middle = (low + high) / 2;
			mergesort(low, middle, numbers);
			mergesort(middle + 1, high, numbers);
			merge(low, high,numbers);
		}
	}

	private static void merge(int low, int high, int[] numbers) {
		// TODO Auto-generated method stub

	}

}
