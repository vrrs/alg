package com.vrrs.alg.problems.interview.bloomberg;

import org.junit.Test;
import com.google.common.collect.ImmutableList;
import static org.assertj.core.api.Assertions.*;

public class TestMaxProfitFinder {
	
	
	@Test
	public void willSolveSample() {
		MaxProfitFinder finder = new MaxProfitFinder();
		int maxProfit = finder.getMaxProfit(ImmutableList.of(10, 20, 10, 5, 4, 0, 200, 0));
		assertThat(maxProfit).isEqualTo(210);
	}
	

}
