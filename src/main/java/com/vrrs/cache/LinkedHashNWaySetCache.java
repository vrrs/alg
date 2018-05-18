package com.vrrs.cache;

import java.util.Optional;

final class LinkedHashNWaySetCache <K, V> implements Cache <K,V> {
	
	private final CacheEntry<K, V>[] entries;
	private final CacheEntry<K, V>[] heads;
	private final EvictionPolicy policy;
	private final IndexMapper<K> indexMapper;
	
	@SuppressWarnings("unchecked")
	public LinkedHashNWaySetCache(int ways, int numOfEntries, EvictionPolicy policy) {
		this.policy = policy;
		this.entries = new CacheEntry[numOfEntries];
		this.heads = newHeadEntries(numOfEntries / ways);
		this.indexMapper = new IndexMapper<>(ways);
	}

	@SuppressWarnings("unchecked")
	private CacheEntry<K, V>[] newHeadEntries(int size) {
		CacheEntry<K, V>[] headEntries = new CacheEntry[size];
		for(int i = 0; i < size; i++) headEntries[i] = CacheEntry.newValueLessEntry();
		return headEntries;
	}

	@Override
	public Optional<V> get(K key) throws KeyNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void put(K key, V value) {
		int set = indexMapper.getIndexOfSet(key);
		if(indexMapper.isSetFull(heads[set])) {
			policy.apply(heads[set]);
		}
		int index = indexMapper.getIndex(key, i -> entries[i] != null);
		CacheEntry<K,V> entry = new CacheEntry<>(key, value, index);
		entries[index] = entry;
		CacheEntry<K, V> tail = heads[set].getTail();
		tail.setRight(entry);
		entry.setLeft(tail);
		heads[set].setTail(entry);
	}

}