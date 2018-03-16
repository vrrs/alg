package com.vrrs.alg.problems.math;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
/**
 * Problem: Given an integer interval [i,j], find the maximum cycle-length of the collatz sequences in this interval. 
 * 
 * @author victor regalado
 */
public class MaxCycleLengthOfCollatzNumbersFinder {
	
	public int getMaxCycleLength(int i, int j){
		List<Integer> collatzSeq = Lists.newArrayListWithCapacity(aproxMaxCycleLength(j));
		Map<Integer, Integer> cycleLengthByNumber = Maps.newHashMap();
		Integer cycleLength, maxCycleLength = 0;
		for(int k = i; k <= j; k++){
			cycleLength = setCollatzSeqAndGetCycleLength(collatzSeq, cycleLengthByNumber, k);
			storeCollatzSeq(collatzSeq, cycleLengthByNumber, cycleLength);
			if(cycleLengthByNumber.containsKey(k) && maxCycleLength < cycleLengthByNumber.get(k))
				maxCycleLength = cycleLengthByNumber.get(k); 
			else if(maxCycleLength < cycleLength)
				maxCycleLength = cycleLength;
		}
		return maxCycleLength;
	}
	
	private Integer setCollatzSeqAndGetCycleLength(List<Integer> collatzSeq, Map<Integer, Integer> cycleLengthByNumber, int collatzNumber) {
		collatzSeq.clear();
		Integer cycleLength = 0;
		while(collatzNumber >= 1){
			if (cycleLengthByNumber.containsKey(collatzNumber) || isPower2(collatzNumber)){
				cycleLength =  isPower2(collatzNumber) ? aproxMaxCycleLength(collatzNumber) :	cycleLengthByNumber.get(collatzNumber);
				break;
			}
			collatzSeq.add(collatzNumber);
			collatzNumber = collatzFunction(collatzNumber);
		}
		return cycleLength;
	}

	private void storeCollatzSeq(List<Integer> collatzSeq, Map<Integer, Integer> cycleLengthByNumber, Integer cycleLength) {
		int m = collatzSeq.size();
		for(int l = 1; l <= m; l++)
			cycleLengthByNumber.put(collatzSeq.get(m-l), cycleLength + l);
	}

	private int collatzFunction(int collatzNumber) {
		return	collatzNumber % 2 == 0 	?	collatzNumber / 2	:	3*collatzNumber + 1;
	}

	private int aproxMaxCycleLength(int j){
		return (int)Math.ceil(logBase2(j)) + 1;
	}
	
	private double logBase2(double a){
		return Math.log10(a) / Math.log10(2);
	}
	
	private boolean isPower2(int a){
		double logOfA = logBase2(a);
		return logOfA - (int)logOfA <= 0;
	}

}
