package com.vrrs.cache;

import java.util.function.Supplier;
import com.vrrs.cache.Cache.CacheEvictionPolicy;

public final class LinkedHashNWaySetCacheBuilder<K, V> implements Supplier<Cache<K, V>> {

	private int numOfWays = 3;
	private int capacity = 3000;
	private EvictionPolicy policy;
	private IndexMapper<K, V> indexMapper;
	
	public LinkedHashNWaySetCacheBuilder<K, V> withNumOfWays(int numOfWays) {
		this.numOfWays = numOfWays;
		return this;
	}

	public LinkedHashNWaySetCacheBuilder<K, V> withCapacity(int capacity) {
		this.capacity = capacity;
		return this;
	}

	public LinkedHashNWaySetCacheBuilder<K, V> withPolicy(CacheEvictionPolicy cacheEvictionPolicy) {
		this.policy = cacheEvictionPolicy.getPolicy();
		return this;
	}
	public LinkedHashNWaySetCacheBuilder<K, V> withPolicy(EvictionPolicy cacheEvictionPolicy) {
		this.policy = cacheEvictionPolicy;
		return this;
	}

	LinkedHashNWaySetCacheBuilder<K, V> withIndexMapper(IndexMapper<K, V> indexMapper) {
		this.indexMapper = indexMapper;
		return this;
	}

	@Override
	public Cache<K, V> get() {
		if (policy == null) {
			throw new IllegalArgumentException("Cache eviction policy must be set.");
		}
		if (numOfWays <= 0 || capacity <= 0 || numOfWays > capacity) {
			throw new IllegalArgumentException(
					"Number of ways and capacity must be positive int and number of ways must be <= capacity.");
		}
		if (indexMapper == null) indexMapper = new HashWithChainingIndexMapper<>(numOfWays, capacity);
		return new LinkedHashNWaySetCache<>(policy, indexMapper);
	}
	
	public static <K, V> LinkedHashNWaySetCacheBuilder<K, V> newBuilder(){
		return new LinkedHashNWaySetCacheBuilder<>();
	}

}
