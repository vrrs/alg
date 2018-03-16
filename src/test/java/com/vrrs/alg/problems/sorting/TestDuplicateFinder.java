package com.vrrs.alg.problems.sorting;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.google.common.collect.ImmutableSet;

public class TestDuplicateFinder {
	private final DuplicateFinder finder = new DuplicateFinder();
	
	@Test
	public void test(){
		int[] elems = {1,2,78,-1,-2,-1,2,78,9,10};
		Integer[] expectation = {2,-1,78};
		assertTrue("Expect duplicates 2,78,-1",ImmutableSet.copyOf(expectation).equals(ImmutableSet.copyOf(finder.getDuplicates(elems))));
	}
}
