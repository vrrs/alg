package com.vrrs.cache;

import java.util.Optional;
import java.util.function.Predicate;

import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

public final class MultiHashIndexMapper<K, V> implements IndexMapper<K, V> {
	
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
		return getConsistentHash(key, numOfSets);
	}
	
	private int getConsistentHash(K key, int numOfBuckets) {
		HashFunction hf = Hashing.sha512();
		HashCode hc = hf.newHasher()
		       .putInt(key.hashCode())
		       .hash();
		return Hashing.consistentHash(hc, numOfBuckets);
	}

	public Optional<Integer> findEntryIndex(K key, Predicate<Integer> stopCondition) {
		int startIndex = getKeySetIndex(key)*setCapacity;
		Predicate<Integer> offsetStopCondition = offset -> stopCondition.test(startIndex + offset);
		return findOffset(key, offsetStopCondition).map(offset -> startIndex + offset);
	}

	private Optional<Integer> findOffset(K key, Predicate<Integer> stopCondition) {
		int hash = getConsistentHash(key, setCapacity);
		for(int i = 0; i < setCapacity; i++) {
			int offset = (hash + i + i*i) % setCapacity;
			if(stopCondition.test(offset)) return Optional.of(offset);
		}
		return Optional.empty();
	}
}