package com.vrrs.alg.problems.combinatorics;

import java.util.List;
import java.util.Map;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * Problem: Given a list of elems, repeated or not, print all pairs whose sum is
 * equal to the given target total.
 * 
 * @Author victor regalado
 **/

public final class PairsOfTargetSum {

	public List<List<Integer>> getPairs(List<Integer> elems, int target) {
		Map<Integer, Integer> hist = histogramOf(elems);
		List<List<Integer>> pairs = Lists.newArrayList(); 
		for (Integer elem1 : elems) {
			int elem2 = target - elem1;
			if(hist.keySet().contains(elem2)) {
				int multiplicity = Math.min(hist.get(elem1), hist.get(elem2));
				multiplicity = elem2 == elem1 ? multiplicity / 2 : multiplicity;
				pairs.addAll(getPairs(elem1, elem2, multiplicity));
				hist.remove(elem1);
				hist.remove(elem2);
			}
		}
		return pairs;
	}

	private Map<Integer, Integer> histogramOf(List<Integer> ar) {
		Map<Integer, Integer> hist = Maps.newLinkedHashMap();
		for (Integer elem : ar) {
			Integer count = hist.get(elem);
			if (count == null) {
				count = 0;
			}
			hist.put(elem, ++count);
		}
		return hist;
	}
	
	private List<List<Integer>> getPairs(int elem1, int elem2, int multiplicity) {
		List<List<Integer>> pairs = Lists.newArrayList();
		for(int i =0; i < multiplicity; i++) {
			pairs.add(ImmutableList.of(elem1, elem2));
		}
		return pairs;
	}

}
