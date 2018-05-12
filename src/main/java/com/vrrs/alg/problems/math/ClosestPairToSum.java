package com.vrrs.alg.problems.math;

import java.util.ArrayList;
import java.util.List;

public class ClosestPairToSum {
	
	public List<Integer> getPairInSortedList(List<Integer> lst, int sum){
		List<Integer> pair = newPair();
		for(int i = 0, j = lst.size() - 1, diff = Integer.MAX_VALUE; j > i;) {
			int curSum = lst.get(i) + lst.get(j);
			int curDiff = Math.abs(sum - curSum);
			if(curDiff < diff) {
				pair.set(0, lst.get(i));
				pair.set(1, lst.get(j));
				diff = curDiff;
			}
			if(curSum > sum) {
				j--;
			} else {
				i++;
			}
		}
		return pair;
	}

	private List<Integer> newPair() {
		List<Integer> pair = new ArrayList<>();
		pair.add(0);pair.add(0);
		return pair;
	}

}
