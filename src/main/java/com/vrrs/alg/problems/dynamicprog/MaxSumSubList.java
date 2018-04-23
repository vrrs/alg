package com.vrrs.alg.problems.dynamicprog;

/**
 * Given array of ints, find the subarray such that sum is max. 
 * @author vregalado
 *
 */
public class MaxSumSubList {
	
	public int[] find(int[] elems) {
		int lb = 0, ub = 0, sum = 0; //rightmost list
		int maxLb = 0, maxUb = 0, maxSum = 0;
		for(int i = 0; i < elems.length; i++) {
			int sumRightMostList = sum;
			if(elems[i] > 0 || sum > 0) {
				ub++;sumRightMostList += elems[i];
			} else if(sum < 0) {
				lb = i; ub = i;
				sumRightMostList = elems[i];
			} 
			if(sumRightMostList > maxSum) {
				maxSum = sumRightMostList;
				maxLb = lb; maxUb = ub;
			}
		}
		int[] maxSumSubList = new int[maxUb - maxLb + 1];
		for(int i = maxLb, j = 0; i <= maxUb; i++) 
			maxSumSubList[j++] = elems[i]; 
		return maxSumSubList;
	}

}
