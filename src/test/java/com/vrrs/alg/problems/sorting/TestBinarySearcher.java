package com.vrrs.alg.problems.sorting;

import org.junit.Test;
import com.google.common.collect.ImmutableList;
import static org.assertj.core.api.Assertions.*;
import java.util.List;

public class TestBinarySearcher {
	
	@Test
	public void willFindBoundaryInListOf0FollowedBy1() {
		final List<Integer> listOf0FollowedBy1 = ImmutableList.of(0,0,0,0,1,1,1);
		BinarySearcher<Integer> binarySearcher = new BinarySearcher<>(Integer::compare);
		int upperBoundFor0 = binarySearcher.getUpperBound(listOf0FollowedBy1, 0);
		assertThat(upperBoundFor0).isEqualTo(3);
		assertThat(binarySearcher.find(listOf0FollowedBy1, -1)).isEqualTo(0);
		int lowerBoundOf1 = binarySearcher.getLowerBound(listOf0FollowedBy1, 1);
		assertThat(lowerBoundOf1).isEqualTo(4);
	}

}
