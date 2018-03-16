package com.vrrs.alg.problems.greedy;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

import com.vrrs.alg.problems.greedy.FractionalKnapsack.Item;

public class TestFractionalKnapsackSolver {
	
	@Test
	public void willFindOptimalKnapsack(){
		final int[] weights = {1,2,3,2,2};
		final int[] values =  {8,4,0,5,3};
		final int capacity = 4;
		List<Item> optimalKnapsack = new FractionalKnapsack().getOptimalKnapsack(weights, values, capacity);
		assertThat(optimalKnapsack).hasSize(3).containsOnly(new Item(8, 1), new Item(5, 2), new Item(2,1));
	}
}
