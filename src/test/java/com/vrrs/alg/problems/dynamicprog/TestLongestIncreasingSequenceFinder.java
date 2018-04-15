package com.vrrs.alg.problems.dynamicprog;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class TestLongestIncreasingSequenceFinder {
	
	@Test
	public void willReturnLongestSeq() {
		int[] seq = new int[] {2, 4, 3, 5, 1, 7, 6, 9, 8};
		int[] longestSeq = new LongestIncreasingSequenceFinder().find(seq);
		assertThat(longestSeq).hasSize(5).contains(2,4,5,7,9);
	}

}
