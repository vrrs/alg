package com.vrrs.alg.problems.greedy;

import java.util.List;
import java.util.Objects;
import java.util.Queue;

import com.google.common.collect.Lists;
import com.google.common.collect.Queues;

/**
 * Also called Continuos knapsack, given a set of items with weight w and value v and capacity K, maximize the # of elements 
 *  in sub-set whose total weight <= K.
 * @author victor regalado
 */
public class FractionalKnapsack {
	
	public static class Item implements Comparable<Item> {
		private final double value;
		private final double weight;
		
		public Item(double value, double weight){
			this.value = value;
			this.weight= weight;
		}
		@Override
		public int hashCode() {
			return Objects.hash(value, weight);
		}
		@Override
		public boolean equals(Object obj) {
			if(obj instanceof Item) {
				Item that = (Item) obj;
				return Objects.equals(this.value, that.value) && 
						Objects.equals(this.weight, that.weight);
			} else {
				return false;
			}
		}
		@Override
		public String toString(){
			return "[" + value +"," + weight + "]";
		}
		@Override
		public int compareTo(Item elem) {
			double ratio1 = (double) this.value / this.weight;
			double ratio2 = (double) elem.value / elem.weight;
			if (ratio1 == ratio2)
				return 0;
			if (ratio1 < ratio2)
				return 1;
			else
				return -1;
		}
	}
	
	
	public List<Item> getOptimalKnapsack(int[] weights, int[] values, int capacity){
		Queue<Item> heap = Queues.newPriorityQueue();
		for(int i = 0; i < weights.length; i++)	heap.add(new Item(values[i], weights[i]));
		List<Item> knapsack = Lists.newArrayList(); 
		for(double totalWeight = 0; heap.size() > 0 && totalWeight < capacity;) {
			Item item = heap.poll();
			if(totalWeight + item.weight <= capacity) {
				totalWeight += item.weight;
			} else {
				double fractionOfLoad = (double) ( capacity - totalWeight ) / item.weight;
				double fractionOfValue = item.value * fractionOfLoad;
				double fractionOfTheWeight = item.weight * fractionOfLoad;
				item = new Item(fractionOfValue, fractionOfTheWeight);
				totalWeight += fractionOfTheWeight;
			}
			knapsack.add(item);
		}
		return knapsack;
	}
	
}
