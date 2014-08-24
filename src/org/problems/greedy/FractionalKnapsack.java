package org.problems.greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;

import org.problems.CollectionUtils;

/**
 * Also called Continuos knapsack, given a set of items with weight w and value v and capacity K, maximize the # of elements 
 *  in sub-set whose total weight <= K.
 * @author victor regalado
 */
public class FractionalKnapsack {
	private List<Item> items;
	private int capacity;
	
	public FractionalKnapsack(int[] weights, int[] values, int capacity){
		this.capacity = capacity;
		items = new ArrayList<Item>(weights.length);
		for(int i = 0; i < weights.length; i++)	items.add(new Item(values[i], weights[i]));
	}
	
	static class Item {
		int value;
		int weight;
		
		Item(int value, int weight){
			this.value = value;
			this.weight= weight;
		}
		@Override
		public String toString(){
			return "[" + value +"," + weight + "]";
		}
	}
	
	public String getKnapsack(){
		Queue<Item> heap = heapOf();
		StringBuilder buff = new StringBuilder();
		double totalWeight = 0;
		do{ Item item = heap.poll();
			if(totalWeight + item.weight <= capacity)	totalWeight += item.weight;
			 else{
				 double fraction = (double) ( capacity - totalWeight ) / item.weight;
				 buff.append(fraction);
				 totalWeight = capacity;
			}
			buff.append(item).append(",");
		}while(heap.size() > 0 && totalWeight != capacity);
		return buff.toString();
	}
	
	private Queue<Item> heapOf(){
		return CollectionUtils.heapOf(items, new Comparator<Item>(){
			public int compare(Item elem1, Item elem2) {
				double ratio1 = (double) elem1.value / elem1.weight;
				double ratio2 = (double) elem2.value / elem2.weight;
				if(ratio1 == ratio2)	return 0;
				if(ratio1 < ratio2)		return 1; 	else return -1;
			}
		});
	}
	
}
