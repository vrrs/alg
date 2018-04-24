package com.vrrs.alg.cs.sorting;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;

import org.assertj.core.util.Lists;

public class TestHeapSort {
	
	@Test
	public void willSortListOfIntsIncreasingly() {
		HeapSort sorter = new HeapSort();
		ArrayList<Integer> elems = Lists.newArrayList(1,5,4,3,2,10);
		sorter.sort(elems, Integer::compareTo);
		assertThat(elems).containsExactly(1,2,3,4,5,10);
	}
	
	@Test
	public void willSortListOfIntsDecreasingly() {
		HeapSort sorter = new HeapSort();
		ArrayList<Integer> elems = Lists.newArrayList(1,5,4,3,2,10);
		sorter.sort(elems, (x,y) -> x==y ? 0 : (x< y ? 1 : 0));
		assertThat(elems).containsExactly(10,5,4,3,2,1);
	}

}
