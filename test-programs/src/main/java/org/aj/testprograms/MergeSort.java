package org.aj.testprograms;

import java.util.Arrays;

public class MergeSort {

	/**
	 * sorts the array of numbers using the basic Merge Sort algorithm
	 * 
	 * @param numbers
	 */
	public static void sort(int[] numbers) {
		System.out.println("Unsorted numbers: " + Arrays.toString(numbers));
		if (numbers.length <= 1)
			return;

		mergesort(0, numbers.length - 1, numbers);
		System.out.println("Sorted numbers" + Arrays.toString(numbers));
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
			merge(low, high, middle, numbers);
		}
	}

	private static void merge(int low, int high, int middle, int[] numbers) {

		// copy into helper
		int[] helper = new int[numbers.length];
		for (int i = low; i < helper.length; i++) {
			helper[i] = numbers[i];
		}
		
		int j = middle + 1;
		int i = low;
		int k = low;

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
