package com.vrrs.alg.problems.dynamicprog;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class TestMaxLengthSubListFinder {
	
	@Test
	public void willReturnLongestSeq() {
		MaxLengthSubListFinder solver = new MaxLengthSubListFinder();
		int[] seq = new int[] {3, 7, 1, 9, 2};
		int[] longestSeq = solver.find(seq, 3);
		assertThat(longestSeq).hasSize(3).contains(3,7,1);
		
		seq = new int[] {5, 10, 15, 20, 25};
		longestSeq = solver.find(seq, 3);
		assertThat(longestSeq).hasSize(2).contains(10, 15);
	}

}
