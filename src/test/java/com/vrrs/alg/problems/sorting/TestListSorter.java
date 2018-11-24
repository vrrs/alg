package com.vrrs.alg.problems.sorting;

import com.google.common.collect.ImmutableList;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

public class TestListSorter {

	@Test
	public void willSortAllLists() {
		List<Integer> aList = ImmutableList.of(1, 4, 5);
		List<Integer> anotherList = ImmutableList.of(2, 8, 10, 11);
		List<List<Integer>> lists = ImmutableList.of(aList, anotherList);
		assertThat(new ListSorter().sortKList(lists))
		.containsExactly(1, 2, 4, 5, 8, 10, 11);
	}
}
