package com.vrrs.alg.problems.combinatorics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public final class Subsets <T extends Comparable<T>> {
	
	public List<Set<T>> getAllSubsets(Set<T> set){
		List<T> elems = new ArrayList<T>(set);
		LinkedHashSet<T> setOfElems = new LinkedHashSet<>(elems);
		List<Set<T>> subsets = new ArrayList<>();
		findAllSubsets(elems, setOfElems, elems.size() - 1, subsets);
		return subsets;
	}
	
	@SuppressWarnings("unchecked")
	private void findAllSubsets(List<T> elems, LinkedHashSet<T> leftSetOfElems, int i, List<Set<T>> subsets) {
		LinkedHashSet<T> rightSetOfElems = (LinkedHashSet<T>) leftSetOfElems.clone();
		leftSetOfElems.remove(elems.get(i));
		if(i == 0) {
			subsets.add(leftSetOfElems);
			subsets.add(rightSetOfElems);
		} else {
			findAllSubsets(elems, leftSetOfElems, i - 1, subsets);
			findAllSubsets(elems, rightSetOfElems, i - 1, subsets);
		}
	}
	
	public List<T> getIntersection(List<List<T>> listOfListOfElems){
		return getIntersection(0, listOfListOfElems.size() - 1, listOfListOfElems);
	}

	private List<T> getIntersection(int lb, int ub, List<List<T>> listOfListOfElems) {
		if(lb >= ub) {
			return listOfListOfElems.get(lb); 
		} else {
			int mid = (ub + lb) / 2;
			List<T> left = getIntersection(lb, mid, listOfListOfElems);
			List<T> right = getIntersection(mid + 1, ub, listOfListOfElems);
			return getIntersection(left, right);
		}
	}

	private List<T> getIntersection(List<T> left, List<T> right) {
		Map<T, Integer> countPerElem = getCountPerElem(left, new HashMap<>());
		countPerElem = getCountPerElem(right, countPerElem);
		List<T> commonElems = new ArrayList<>();
		for(Map.Entry<T, Integer> entry : countPerElem.entrySet()) {
			if(entry.getValue() > 1) commonElems.add(entry.getKey());
		}
		return commonElems;
	}

	private Map<T, Integer> getCountPerElem(List<T> elems, Map<T, Integer> prevCountPerElem) {
		Map<T, Integer> countPerElem = new HashMap<>();
		for(T elem : elems) {
			Integer count = countPerElem.get(elem);
			if(count == null) {
				count = 1;
				countPerElem.put(elem, count);
			} 
			if(prevCountPerElem.containsKey(elem)) countPerElem.put(elem, ++count);
		}
		return countPerElem;
	}
	
	public List<T> getKMostFrequent(List<T> elems, int k){
		Map<T, Integer> countPerElem = getCountPerElem(elems);
		Comparator<T> cmp = (x,y) -> {
			int countX = countPerElem.get(x);
			int countY = countPerElem.get(y);
			return countX == countY ? 0 : (countX > countY ? -1 : 1);
		};
		Queue<T> queue = new PriorityQueue<>(cmp);
		for(T elem : countPerElem.keySet()) queue.add(elem);
		List<T> kMostFrequentElems = new ArrayList<>();
		for(int i = 0; i < k && !queue.isEmpty(); i++) {
			kMostFrequentElems.add(queue.poll());
		}
		return kMostFrequentElems;
	}

	private Map<T, Integer> getCountPerElem(List<T> elems) {
		Map<T, Integer> countPerElem = new HashMap<>();
		for(T elem : elems) {
			Integer count = countPerElem.get(elem);
			count = count == null ? 1 : ++count;
			countPerElem.put(elem, count);
		}
		return countPerElem;
	}

}
