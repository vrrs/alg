package com.vrrs.alg.problems.dynamicprog;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TestMaxSumInList {
	
	@Test
	public void willFindMaxSumSubList() {
		MaxSumInList finder = new MaxSumInList();
		int[] elems = new int[] {1,2,-3,6,1};
		assertThat(finder.findMaxSumInSubList(elems)).hasSize(2).contains(6, 1);
		
		elems = new int[] {1,2,-1,6,1};
		assertThat(finder.findMaxSumInSubList(elems)).hasSize(4).contains(1,2,-1,6);
	}
	
	@Test
	public void willFindMaxSumInSubSeqWithNoAdjacentElems() {
		MaxSumInList finder = new MaxSumInList();
		Integer[] elems = new Integer[] {5, 5, 10, 100, 10, 5};
		assertThat(finder.findMaxSubSeqWithNoAdjacentElems(elems))
		.hasSize(3).contains(5, 100, 5);
		
		elems = new Integer[] {1, 2, 3};
		assertThat(finder.findMaxSubSeqWithNoAdjacentElems(elems))
		.hasSize(2).contains(1, 3);
		
		elems = new Integer[] {1, 20, 3};
		assertThat(finder.findMaxSubSeqWithNoAdjacentElems(elems))
		.hasSize(1).contains(20);
	}

}
