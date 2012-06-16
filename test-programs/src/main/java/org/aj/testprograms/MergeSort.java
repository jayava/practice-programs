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
			merge(low, high, numbers);
		}
	}

	private static void merge(int low, int high, int[] numbers) {

		// copy into helper
		int[] helper = new int[high - low + 1];
		int k = low;
		for (int i = 0; i < helper.length; i++) {
			helper[i] = numbers[k++];
		}
		
		int middle = (high - low)/2;
		int j = middle + 1;
		int i = 0;
		k = low;

		while (i <= middle) {
			if (j <= high) {
				if (helper[i] <= helper[j]) {
					numbers[k] = helper[i];
					i++;
				} else {
					numbers[k] = helper[j];
					j++;
				}
			} else {
				numbers[k] = helper[i];
				i++;
			}
			k++;
		}

		while (j <= high) {
			numbers[k++] = helper[j++];
		}
	}

}
