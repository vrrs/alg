package org.problems.sorting;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TestMergeSort {
	@Test
	public void test(){
		int[] elems = {1,2,1,5,4,3,9};
		Sort sorter = new MergeSort();
		sorter.sort(elems);
		int[] expectation = {1,1,2,3,4,5,9};
		assertTrue("Array element", equalArrays(elems, expectation));
	}

	private boolean equalArrays(int[] actual, int[] expectation) {
		for(int i = 0; i < actual.length; i++)	if(actual[i] != expectation[i])	return false;
		return true;
	}
	

}
