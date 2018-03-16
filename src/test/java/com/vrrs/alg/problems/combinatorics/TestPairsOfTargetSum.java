package com.vrrs.alg.problems.combinatorics;

import org.junit.Test;
import com.google.common.collect.ImmutableList;
import static org.assertj.core.api.Assertions.*;
import java.util.List;

public class TestPairsOfTargetSum {
	
	@Test
	public void willReturnPairsTotaling10() {
		List<Integer> elems = ImmutableList.of(1,1,6,5,5,5,4,9,11,10,7,3,10,7,11,3,7);
		List<List<Integer>> pairs = new PairsOfTargetSum().getPairs(elems, 10);
		assertThat(pairs).hasSize(5)
			.containsOnly(pair(1,9), pair(5,5), pair(6,4), pair(7, 3));
	}
	
	private List<Integer> pair(int a, int b){
		return ImmutableList.of(a, b);
	}

}
