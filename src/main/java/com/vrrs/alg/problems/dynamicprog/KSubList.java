package com.vrrs.alg.problems.dynamicprog;

import java.util.List;

import com.google.common.collect.ImmutableList;

public class KSubList {
	
	private final int k;

	public KSubList(int k) {
		this.k = k;
	}
	
	public List<Integer> getSubListWithSum(List<Integer> elems, int sum){
		boolean notMatched = true;
		int total = 0;
		int lb = 0, ub = k - 1;
		for(int i = lb; i <= ub; i++) total += elems.get(i);
		for(ub = k; (notMatched = total != sum) && ub < elems.size(); ub++) {
			lb = ub - k + 1;
			total +=  (elems.get(ub) - elems.get(lb - 1));
		}
		return !notMatched ? elems.subList(lb, ub) : ImmutableList.of();
	}

}
