package org.aj.testprograms;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

public class TestMergeSort {

	private static final int MAX_SIZE = 100;

	@Test
	public void testOddNumberOfElements() {
		
		int[] input = {3,1,4,17,5};
		int[] output = {1,3,4,5,17};
		MergeSort.sort(input);
		
		assertArrayEquals(output, input);
	}

	@Test
	public void testEvenNumberOfElements() {
		
		int[] input = {3,1,4,17,5,8};
		int[] output = {1,3,4,5,8,17};
		MergeSort.sort(input);
		
		assertArrayEquals(output, input);
	}
	
	@Test
	public void testSortOnSortedArray() {
		
		int[] input = {1,3,4,5,8,17};
		int[] output = {1,3,4,5,8,17};
		MergeSort.sort(input);
		
		assertArrayEquals(output, input);
	}
	
	@Test
	public void testRandomNumberRuns() {
		
		Random r = new Random(17);
		int[] input = new int[MAX_SIZE];
		for(int i=0; i < input.length; i++ ){
			input[i] = r.nextInt();
		}
		
		MergeSort.sort(input);
		int[] output  = Arrays.copyOf(input, MAX_SIZE);
		Arrays.sort(output);
		assertArrayEquals(output, input);
	}
}
