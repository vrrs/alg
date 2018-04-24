package com.vrrs.alg.problems.dynamicprog;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Find max length sublist such that any pair is not divisible by a given int k
 * @author vregalado
 */
public class MaxLengthSubListFinder {
	
	public int[] find(int[] list, int k) {
		Map<Integer, Integer> locByRemainder = new LinkedHashMap<>();
		int lb = 0, ub = 0; // rightmost sublist
		int maxLb = 0, maxUb = 0;
		for (int i = 0; i < list.length; i++) {
			int r = list[i] % k;
			Integer loc = locByRemainder.get(k - r);
			if (loc == null || loc < lb) {
				ub = i;
				locByRemainder.put(r, i);
				if(r == 0)	locByRemainder.put(k, list.length);
			} else if (i - loc >= 1) {
				ub = i;
				lb = loc + 1;
				locByRemainder.put(r, i);
				if(r == 0)	locByRemainder.put(k, list.length);
			}
			if (maxUb + maxLb + 1 < ub - lb + 1) {
				maxUb = ub;
				maxLb = lb;
			}
		}
		int[] sublist = new int[maxUb - maxLb + 1];
		for (int j = maxLb, i = 0; j <= maxUb; j++) sublist[i++] = list[j];
		return sublist;
	}

}
