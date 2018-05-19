package com.vrrs.cache;

import java.util.Optional;
import java.util.function.Predicate;

interface IndexMapper<K, V> {

	boolean isSetFull(LinkedListHeader<K, V> head);
	int getKeySetIndex(K key);
	Optional<Integer> findEntryIndex(K key, Predicate<Integer> stopCondition);

	static final class MultiHashIndexMapper<K, V> implements IndexMapper<K, V> {
		private final int ways;

		public MultiHashIndexMapper(int ways) {
			this.ways = ways;
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
