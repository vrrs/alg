package org.problems.sorting;

import static org.junit.Assert.assertTrue;
import static org.problems.TestUtils.compareArrays;

import org.junit.Ignore;
import org.junit.Test;

public class TestQuickSort {
	
	@Test
	public void testIterativeImplementation(){
		Integer[] input = {1, 5, 2, 9, -1, -4, 9};
		Integer[] actual = QuickSort.quickSort(input);
		Integer[] expected = {-4, -1, 1, 2, 5, 9, 9};
		assertTrue("Expect sorted array {-4, -1, 1, 2, 5, 9, 9} from {1, 5, 2, 9, -1, -4, 9}.", compareArrays(expected,actual));
	}

	@Test
	public void testRecursiveImplementation(){
		Integer[] input = {1, 5, 2, 9, -1, -4, 9};
		Integer[] actual = QuickSort.recursiveQuickSort(input);
		Integer[] expected = {-4, -1, 1, 2, 5, 9, 9};
		assertTrue("Expect sorted array {-4, -1, 1, 2, 5, 9, 9} from {1, 5, 2, 9, -1, -4, 9}.", compareArrays(expected,actual));
	}
}
