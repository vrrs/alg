package com.vrrs.cache;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.IntStream;

final class LinkedHashNWaySetCache <K, V> implements Cache <K,V> {
	
	private final CacheEntry<K, V>[] entries;
	private final LinkedListHeader<K, V>[] headers;
	private final EvictionPolicy policy;
	private final IndexMapper<K, V> indexMapper;
	private final Consumer<Integer> entryEviction;
	
	@SuppressWarnings("unchecked")
	public LinkedHashNWaySetCache(EvictionPolicy policy, IndexMapper<K, V> indexMapper) {
		this.policy = policy;
		this.entries = new CacheEntry[indexMapper.getNumOfEntries()];
		this.headers = newLinkedListHeaders(indexMapper.getNumOfSets());
		this.indexMapper = indexMapper;
		this.entryEviction = i -> entries[i] = null;
	}

	private LinkedListHeader<K, V>[] newLinkedListHeaders(int size) {
		@SuppressWarnings("unchecked")
		LinkedListHeader<K, V>[] headers = new LinkedListHeader[size];
		IntStream.range(0, size).forEach(i -> headers[i] = new LinkedListHeader<>());
		return headers;
	}

	@Override
	public Optional<V> get(K key) {
		int set = indexMapper.getKeySetIndex(key);
		return indexMapper.findEntryIndex(key, i -> 
					entries[i] != null && entries[i].getKey().equals(key))
				.map(i -> entries[i])
				.map(entry -> getAndSetEntryAsMostRecent(set, entry))
				.map(CacheEntry::getValue);
	}

	@Override
	public void put(K key, V value) {
		int set = indexMapper.getKeySetIndex(key);
		if (indexMapper.isSetFull(headers[set])) {
			policy.apply(headers[set], entryEviction);
		}
		indexMapper.findEntryIndex(key, i -> entries[i] == null)
			.map(i -> new CacheEntry<>(key, value, i))
			.map(entry -> getAndSetEntryAsMostRecent(set, entry))
			.map(entry -> getAndSetEntry(set, entry))
			.get();
	}
	
	private CacheEntry<K,V> getAndSetEntry(int set, CacheEntry<K,V> entry){
		entries[entry.getIndex()] = entry;
		int listSize = headers[set].getListSize();
		headers[set].setListSize(++listSize);
		return entry;
	}

	private CacheEntry<K, V> getAndSetEntryAsMostRecent(int set, CacheEntry<K, V> entry) {
		CacheEntry<K, V> tail = headers[set].getTail();
		if(tail == entry) return entry;
		if(tail != null) {
			tail.setRight(entry);
			CacheEntry<K, V> left = entry.getLeft();
			CacheEntry<K, V> right = entry.getRight();
			if(left != null) left.setRight(right);
			if(right != null) right.setLeft(left);
			entry.setLeft(tail);	
		} else {
			headers[set].setHead(entry);	
		}
		headers[set].setTail(entry);
		entry.setRight(null);
		return entry;
	}

}
