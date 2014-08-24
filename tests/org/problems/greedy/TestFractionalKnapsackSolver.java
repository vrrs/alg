package org.problems.greedy;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestFractionalKnapsackSolver {
	@Test
	public void test(){
		final int[] weights = {1,2,3,2,2};
		final int[] values =  {8,4,0,5,3};
		final int capacity = 4;
		FractionalKnapsack solver = new FractionalKnapsack(weights, values, capacity);
		String actual = solver.getKnapsack();
		assertEquals("Must match expectation.", "[8,1],[5,2],0.5[4,2],", actual);
	}
}
