package com.vrrs.cache;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.IntStream;

final class LinkedHashNWaySetCache <K, V> implements Cache <K,V> {
	
	private final CacheEntry<K, V>[] entries;
	private final LinkedListHeader<K, V>[] heads;
	private final EvictionPolicy policy;
	private final IndexMapper<K, V> indexMapper;
	private final Consumer<Integer> entryEviction;
	
	@SuppressWarnings("unchecked")
	public LinkedHashNWaySetCache(int ways, int numOfEntries, EvictionPolicy policy, IndexMapper<K, V> indexMapper) {
		this.policy = policy;
		this.entries = new CacheEntry[numOfEntries];
		this.heads = newHeadEntries(numOfEntries / ways);
		this.indexMapper = indexMapper;
		this.entryEviction = i -> entries[i] = null;
	}

	private LinkedListHeader<K, V>[] newHeadEntries(int size) {
		@SuppressWarnings("unchecked")
		LinkedListHeader<K, V>[] headEntries = new LinkedListHeader[size];
		IntStream.range(0, size).forEach(i -> headEntries[i] = new LinkedListHeader<>());
		return headEntries;
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
		if (indexMapper.isSetFull(heads[set])) {
			policy.apply(heads[set], entryEviction);
		}
		indexMapper.findEntryIndex(key, i -> entries[i] == null)
			.map(i -> new CacheEntry<>(key, value, i))
			.map(entry -> getAndSetEntryAsMostRecent(set, entry))
			.map(this::getAndSetEntry)
			.get();
	}
	
	private CacheEntry<K,V> getAndSetEntry(CacheEntry<K,V> entry){
		entries[entry.getIndex()] = entry;
		return entry;
	}

	private CacheEntry<K, V> getAndSetEntryAsMostRecent(int set, CacheEntry<K, V> entry) {
		CacheEntry<K, V> tail = heads[set].getTail();
		if(tail != null) {
			tail.setRight(entry);
			entry.setLeft(tail);	
		} else {
			heads[set].setHead(entry);	
		}
		heads[set].setTail(entry);
		return entry;
	}

}
