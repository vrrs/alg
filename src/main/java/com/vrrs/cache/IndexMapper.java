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
		
		private static final double INVERSE_OF_LOAD_FACTOR = 1.34;
		
		private final int setCapacity;
		private final int numOfSets;
		private final int numOfEntries;
		private final int ways;

		public MultiHashIndexMapper(int ways, int capacity) {
			this.setCapacity = (int) Math.ceil(INVERSE_OF_LOAD_FACTOR * ways);
			this.numOfSets = getNumOfSets(ways, capacity);
			this.numOfEntries = this.setCapacity * this.numOfSets;
			this.ways = ways;
		}
		
		public int getNumOfSets() {
			return numOfSets;
		}
		
		public int getNumOfEntries() {
			return numOfEntries;
		}
		
		private int getNumOfSets(int ways, int capacity) {
			int remainder = capacity % ways;
			int numOfSets = capacity / ways;
			if(remainder > 0) {
				numOfSets++;
			}
			return numOfSets;
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
