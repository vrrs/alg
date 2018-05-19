package com.vrrs.cache;

import java.util.Optional;
import java.util.function.Predicate;

interface IndexMapper<K, V> {

	boolean isSetFull(LinkedListHeader<K, V> head);
	int getKeySetIndex(K key);
	Optional<Integer> findEntryIndex(K key, Predicate<Integer> stopCondition);
	int getNumOfSets();
	int getNumOfEntries();

	static final class MultiHashIndexMapper<K, V> implements IndexMapper<K, V> {
		private final int ways;
		private final int capacity;

		public MultiHashIndexMapper(int ways, int capacity) {
			this.ways = ways;
			this.capacity = capacity;
		}
		
		public int getNumOfSets() {
			
		}
		
		public int getNumOfEntries() {
			
		}
		
		private int getUniformNumOfEntries(int numOfEntries, int numOfWays) {
			int remainder = numOfEntries % numOfWays;
			if(remainder > 0) {
				numOfEntries -= remainder; 
			}
			return numOfEntries;
		}

		public boolean isSetFull(LinkedListHeader<K, V> head) {
			return head.getListSize() == ways;
		}
		
		public int getKeySetIndex(K key) {
			return 0;
		}

		public Optional<Integer> findEntryIndex(K key, Predicate<Integer> stopCondition) {
			return null;
		}
	}
}
