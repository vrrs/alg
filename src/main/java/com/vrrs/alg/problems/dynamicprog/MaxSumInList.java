package com.vrrs.alg.problems.dynamicprog;

import java.util.ArrayList;
import java.util.List;

/**
 * Given array of ints(pos or neg), find the subarray such that sum is max. 
 * @author vregalado
 *
 */
public class MaxSumInList {
	
	public int[] findMaxSumInSubList(int[] elems) {
		if(elems.length == 0) return elems;
		int maxLb = 0, maxUb = 0, maxSum = elems[0];
		for(int i = 1, sum = elems[0], lb = 0, ub = 0; i < elems.length; i++) {
			int elem = elems[i];
			if(sum <= 0) {
				lb = i; ub = i; sum = elem;
			} else {
				ub++; sum += elem;
			}
			if(sum > maxSum && ub-lb+1 < elems.length) {
				maxUb = ub; maxLb = lb; maxSum = sum; 
			}
		}
		return getSubList(elems, maxLb, maxUb); 
	}

	private int[] getSubList(int[] elems, int maxLb, int maxUb) {
		int[] maxSumSubList = new int[maxUb - maxLb + 1];
		for(int i = maxLb, j = 0; i <= maxUb; i++) maxSumSubList[j++] = elems[i];
		return maxSumSubList;
	}
	
	public Integer[] findMaxSubSeqWithNoAdjacentElems(Integer[] elems) {
		if(elems.length == 0) return elems;
		List<Integer> prev2 = new ArrayList<>();prev2.add(elems[0]);
		List<Integer> prev1 = new ArrayList<>();prev1.add(elems[0]);
		for(int i = 1, sum2 = elems[0], sum1 = 0, curSum = 0; i < elems.length; i++) {
			int elem = elems[i];
			if(i == 1) {
				curSum = sum1 = Math.max(elems[0], elem);
				prev1.set(0, sum1); continue;
			}
			List<Integer> cur = prev1;
			curSum = sum1;
			if(sum2 + elem > sum1) {
				curSum = sum2 + elem;
				cur = prev2;
				prev2.add(elem);
			}
			prev2 = prev1;
			prev1 = cur;
			sum2 = sum1;
			sum1 = curSum;
		}
		return prev1.toArray(new Integer[prev1.size()]); 
	}

}
