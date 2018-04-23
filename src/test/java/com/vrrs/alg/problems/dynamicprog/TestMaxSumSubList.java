package com.vrrs.alg.problems.dynamicprog;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TestMaxSumSubList {
	
	@Test
	public void willFindMaxSumSubList() {
		MaxSumSubList finder = new MaxSumSubList();
		int[] elems = new int[] {1,2,-3,6,1};
		assertThat(finder.find(elems)).hasSize(4).contains(1,2,-3,6);
	}

}
