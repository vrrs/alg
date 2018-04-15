package com.vrrs.alg.problems.interview.bloomberg;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.vrrs.alg.problems.interview.bloomberg.OptimalTradeFinder.Trade;

public class TestOptimalTradeFinder {
	
	@Test
	public void willSolveSample() {
		OptimalTradeFinder finder = new OptimalTradeFinder();
		Trade trade = finder.getOptimalTrade(ImmutableList.of(1,4,3,7,9,54,30,7,4));
		assertThat(trade.getBuy()).isEqualTo(1);
		assertThat(trade.getSell()).isEqualTo(54);
	}

}
