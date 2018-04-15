package com.vrrs.alg.problems.interview.bloomberg;

import java.util.List;

public class MaxProfitFinder {

	public int getMaxProfit(List<Integer> prices) {
		int profit = 0;
		boolean isHolding = false;
		for (int hold = 0, i = 0; i < prices.size() - 1; i++) {
			int cur = prices.get(i);
			int next = prices.get(i + 1);
			if (!isHolding && cur < next) {
				hold = cur;
				isHolding = true;
			} else if (isHolding && cur > next) {
				profit += cur - hold;
				hold = 0;
				isHolding = false;
			}
		}
		return profit;
	}

}
