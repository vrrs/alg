package com.vrrs.cache;

import java.util.Optional;
import java.util.function.Predicate;

interface IndexMapper<K, V> {

	int getKeySetIndex(K key);
	boolean isEmpty(LinkedListHeader<K, V> head);
	Optional<Integer> findIndex(K key, Predicate<Integer> stopCondition);

	static final class MultiHashIndexMapper<K, V> implements IndexMapper<K, V> {
		private final int ways;

		public MultiHashIndexMapper(int ways) {
			this.ways = ways;
		}

		public int getKeySetIndex(K key) {
			return 0;
		}

		public boolean isEmpty(LinkedListHeader<K, V> head) {
			return false;
		}

		public Optional<Integer> findIndex(K key, Predicate<Integer> stopCondition) {
			return null;
		}
	}
}
