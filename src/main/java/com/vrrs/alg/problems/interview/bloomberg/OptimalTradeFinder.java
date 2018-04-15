package com.vrrs.alg.problems.interview.bloomberg;

import java.util.List;

public class OptimalTradeFinder {
	
	public static class Trade {
		private final int buy;
		private final int sell;
		public Trade(int buy, int sell) {
			this.buy = buy;
			this.sell = sell;
		}
		public int getBuy() {
			return buy;
		}
		public int getSell() {
			return sell;
		}
	}
	
	public Trade getOptimalTrade(List<Integer> prices) {
		int buy = 0, sell = 0;
		for (int nextMin = 0, maxProfit = -1, curMin = prices.get(0), i = 1; i < prices.size(); i++) {
			nextMin = Math.min(curMin, prices.get(i));
			int pSell = prices.get(i);
			int pBuy = curMin;
			int profit = pSell - pBuy;
			if (profit > maxProfit) {
				buy = pBuy;
				sell = pSell;
				maxProfit = profit;
			}
			curMin = nextMin;
		}
		return new Trade(buy, sell);
	}

}
