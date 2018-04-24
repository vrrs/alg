package com.vrrs.alg.cs.sorting;

import java.util.Comparator;
import java.util.List;

import com.vrrs.alg.cs.datastructures.ArrayHeap;

public class HeapSort {
	
	public <E> void sort(List<E> elems, Comparator<E> cmp){
		ArrayHeap<E> heap = new ArrayHeap<>(cmp);
		for(E elem : elems)	heap.add(elem);
		for(int i = elems.size() - 1; i >= 0; i--) {
			elems.set(i, heap.pollHead());
		}
	}

}
