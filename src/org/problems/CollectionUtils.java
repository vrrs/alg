package org.problems;

import java.util.Collection;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public final class CollectionUtils {
	
	public static <T> Queue<T> heapOf(Collection<T> elems, Comparator<T> cmp){
		Queue<T> heap = new PriorityQueue<T>(elems.size(), cmp);
		for(T elem : elems)	heap.add(elem);
		return heap;
	}
}
