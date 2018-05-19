package com.vrrs.cache;

import java.util.Optional;
import java.util.function.Predicate;

interface IndexMapper<K, V> {

	boolean isSetFull(LinkedListHeader<K, V> head);
	int getKeySetIndex(K key);
	Optional<Integer> findEntryIndex(K key, Predicate<Integer> stopCondition);
	int getNumOfSets();
	int getNumOfEntries();
}
