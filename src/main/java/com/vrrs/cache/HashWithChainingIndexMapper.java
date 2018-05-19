package com.vrrs.cache;

import java.util.Optional;
import java.util.function.Predicate;

import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

final class HashWithChainingIndexMapper <K, V> implements IndexMapper<K, V> {

	private final int numOfSets;
	private final int numOfEntries;
	private final int ways;

	public HashWithChainingIndexMapper(int ways, int capacity) {
		this.numOfSets = capacity / ways;
		this.numOfEntries = ways * this.numOfSets;
		this.ways = ways;
	}

	@Override
	public boolean isSetFull(LinkedListHeader<K, V> head) {
		return head.getListSize() == ways;
	}

	@Override
	public int getKeySetIndex(K key) {
		return getConsistentHash(key, numOfSets);
	}
	
	private int getConsistentHash(K key, int numOfBuckets) {
		HashFunction hf = Hashing.sha512();
		HashCode hc = hf.newHasher()
		       .putInt(key.hashCode())
		       .hash();
		return Hashing.consistentHash(hc, numOfBuckets);
	}

	@Override
	public Optional<Integer> findEntryIndex(K key, Predicate<Integer> stopCondition) {
		int startIndex = getKeySetIndex(key)*ways;
		for(int i = startIndex; i < ways + startIndex; i++) {
			if(stopCondition.test(i)) return Optional.of(i);
		}
		return Optional.empty();
	}

	@Override
	public int getNumOfSets() {
		return this.numOfSets;
	}

	@Override
	public int getNumOfEntries() {
		return this.numOfEntries;
	}

}
