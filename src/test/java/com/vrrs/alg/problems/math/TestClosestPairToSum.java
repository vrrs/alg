package com.vrrs.alg.problems.math;

import org.junit.Test;
import com.google.common.collect.ImmutableList;
import static org.assertj.core.api.Assertions.*;
import java.util.List;

public class TestClosestPairToSum {
	
	@Test
	public void willReturnClosestPair() {
		List<Integer> pair = new ClosestPairToSum()
				.getPairInSortedList(ImmutableList.of(10, 22, 28, 29, 30, 40), 54);
		assertThat(pair).containsExactly(22, 30);
	}

}
