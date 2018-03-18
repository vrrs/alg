package com.vrrs.alg.cs.sorting;

import java.util.List;
import org.junit.Test;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.vrrs.alg.cs.sorting.QuickSort;
import static org.assertj.core.api.Assertions.*;

public class TestQuickSort {
	
	private static final List<Integer> ORDERED_LIST = ImmutableList.of(-4, -1, 1, 2, 5, 9, 9);
	
	@Test
	public void testIterativeImplementation(){
		Integer[] unorderedList = {1, 5, 2, 9, -1, -4, 9};
		QuickSort<Integer> sorter = new QuickSort<>(Integer::compare);
		List<Integer> actualOrderedList = Lists.newArrayList(sorter.sortIteratively(unorderedList));
		assertThat(actualOrderedList).isEqualTo(ORDERED_LIST);
	}

	@Test
	public void testRecursiveImplementation(){
		Integer[] unorderedList = {1, 5, 2, 9, -1, -4, 9};
		QuickSort<Integer> sorter = new QuickSort<>(Integer::compare);
		List<Integer> actualOrderedList = Lists.newArrayList(sorter.sortRecursively(unorderedList));
		assertThat(actualOrderedList).isEqualTo(ORDERED_LIST);
	}
}
