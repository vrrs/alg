package com.vrrs.alg.problems.combinatorics;

import java.util.List;
import java.util.Set;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

public class TestSubsets {
	
	@Test
	public void willReturnAllSubsets() {
		List<Set<Integer>> subsets = new Subsets<Integer>()
				.getAllSubsets(ImmutableSet.of(1,2));
		assertThat(subsets).contains(ImmutableSet.of(1,2))
		.contains(ImmutableSet.of(1))
		.contains(ImmutableSet.of(2))
		.contains(ImmutableSet.of());
	}
	
	@Test
	public void willFindIntersectionOfAllLists() {
		List<Integer> intersection = new Subsets<Integer>()
				.getIntersection(ImmutableList.of(ImmutableList.of(2, 6, 6, 9, 11, 13, 17),
						ImmutableList.of(3, 6, 7, 10, 13, 18), 
						ImmutableList.of(4, 4, 5, 6, 6, 9, 11, 13)));
		
		assertThat(intersection).contains(6, 13).hasSize(2);
	}
	
	@Test
	public void willFindTheKMostFrequentElems() {
		List<Integer> twoMostFrequentElems = new Subsets<Integer>()
				.getKMostFrequent(ImmutableList.of(1, 6, 2, 1, 6, 1), 2);
		assertThat(twoMostFrequentElems).contains(1, 6).hasSize(2);
	}

}
