package com.vrrs.alg.cs.sorting;

import java.util.List;
import org.junit.Test;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.vrrs.alg.cs.sorting.QuickSort;
import static org.assertj.core.api.Assertions.*;

public class TestQuickSort {
	
	@Test
	public void testIterativeImplementation(){
		Integer[] elems = {1, 5, 2, 9, -1, -4, 9};
		List<Integer> actual = Lists.newArrayList(QuickSort.quickSort(elems, Integer::compare));
		assertThat(actual).isEqualTo(ImmutableList.of(-4, -1, 1, 2, 5, 9, 9));
	}

	@Test
	public void testRecursiveImplementation(){
		Integer[] elems = {1, 5, 2, 9, -1, -4, 9};
		List<Integer> actual = Lists.newArrayList(QuickSort.recursiveQuickSort(elems, Integer::compare));
		assertThat(actual).isEqualTo(ImmutableList.of(-4, -1, 1, 2, 5, 9, 9));
	}
}
