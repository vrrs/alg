package com.vrrs.alg.cs.sorting;

import java.util.Comparator;
import java.util.Deque;

import com.google.common.collect.Queues;

import io.vavr.Tuple;
import io.vavr.Tuple2;

public class QuickSort<T> {
	
	private final Comparator<T> comparator;

	public QuickSort(Comparator<T> comparator) {
		this.comparator = comparator;
	}
	
	public T[] sortIteratively(T[] ar){
		Deque<Tuple2<Integer, Integer>> boundQueue = Queues.newArrayDeque();
		for(boundQueue.push(bound(0, ar.length - 1)); !boundQueue.isEmpty();) {
			Tuple2<Integer, Integer> bound = boundQueue.poll();
			int pivot = getCentralPivot(bound._1, bound._2);
			pivot = partition(ar, bound._1, bound._2, pivot);
			if((pivot - 1) - bound._1 + 1 > 1)	boundQueue.push(bound(bound._1, pivot - 1));
			if(bound._2 - (pivot + 1) + 1 > 1)	boundQueue.push(bound(pivot + 1, bound._2));
		}
		return ar;
	}
	
	private Tuple2<Integer, Integer> bound(int lowerBound, int upperBound) {
		return Tuple.of(lowerBound, upperBound);
	}

	public T[] sortRecursively(T[] ar){
		return recursiveQuickSort(ar, 0, ar.length - 1);
	}
	
	private T[] recursiveQuickSort(T[] ar, int lowerBound, int upperBound){
		if(upperBound > lowerBound){
			int pivot = getCentralPivot(lowerBound, upperBound);
			pivot = partition(ar, lowerBound, upperBound, pivot);
			recursiveQuickSort(ar, lowerBound, pivot - 1);
			recursiveQuickSort(ar, pivot + 1, upperBound);
		}
		return ar;
	}
	
	private int partition(T[] ar, int lowerBound, int upperBound, int pivot){
		swap(ar, lowerBound, pivot);
		return partition(ar, lowerBound, upperBound);
	}
	
	private int getCentralPivot(int lowerBound, int upperBound){
		return (upperBound - lowerBound + 1) / 2 + lowerBound;
	}
	
	/**
	 * Left-pivot partition routine.
	 * @param ar T array of n elems
	 * @return index j | for all i,k in [0,n), if i<=j<=k then ar[i] <= ar[j] <= ar[k]  
	 */
	private int partition(T[] ar, int lowerBound, int upperBound){
		if(upperBound > lowerBound){
			T pivot = ar[lowerBound];
			int i = lowerBound + 1;
			for(int j = lowerBound + 1; j <= upperBound; j++)
				if(comparator.compare(ar[j], pivot) == -1)
					swap(ar, i++, j);
			swap(ar, i-1, lowerBound);
			return i-1;
		}
		return lowerBound;
	}
	
	private void swap(T[] ar, int left, int right){
		T temp = ar[left];
		ar[left] = ar[right];
		ar[right] = temp;
	}

}
