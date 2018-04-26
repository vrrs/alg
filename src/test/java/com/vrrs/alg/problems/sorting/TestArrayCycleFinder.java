package com.vrrs.alg.problems.sorting;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class TestArrayCycleFinder {

	@Test
	public void willFindCycle() {
		ArrayCycleFinder cycleFinder = new ArrayCycleFinder();
		int[] elems = new int[] { 2, -1, 1, 2, 2 };
		assertThat(cycleFinder.hasCycle(elems)).isTrue();

		elems = new int[] { 1, 1, 1, 1, 1, 1 };
		assertThat(cycleFinder.hasCycle(elems)).isTrue();

		elems = new int[] { 1, 2 };
		assertThat(cycleFinder.hasCycle(elems)).isFalse();
	}

}
