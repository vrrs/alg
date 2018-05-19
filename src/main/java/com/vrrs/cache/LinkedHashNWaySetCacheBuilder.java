package com.vrrs.cache;

import java.util.function.Supplier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vrrs.cache.Cache.CacheEvictionPolicy;

public final class LinkedHashNWaySetCacheBuilder<K, V> implements Supplier<Cache<K, V>> {

	private static final Logger LOG = LoggerFactory.getLogger(LinkedHashNWaySetCacheBuilder.class);
	
	private int numOfWays = 3;
	private int numOfEntries = 3000;
	private EvictionPolicy policy;
	private IndexMapper<K, V> indexMapper;
	
	public LinkedHashNWaySetCacheBuilder<K, V> withNumOfWays(int numOfWays) {
		this.numOfWays = numOfWays;
		return this;
	}

	public LinkedHashNWaySetCacheBuilder<K, V> withNumOfEntries(int numOfEntries) {
		this.numOfEntries = numOfEntries;
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
		if (numOfWays <= 0 || numOfEntries <= 0 || numOfWays > numOfEntries) {
			throw new IllegalArgumentException(
					"Number of ways and entries must be positive int and number of ways must be <= number of entries.");
		}
		int uniformNumOfEntries = getUniformNumOfEntries(numOfEntries, numOfWays);
		if (indexMapper == null) indexMapper = new IndexMapper.MultiHashIndexMapper<>(numOfWays);
		LOG.info("Built a LinkedHashNWaySetCache with uniform number of entries, " + uniformNumOfEntries + ", given "
				+ numOfEntries + " with " + numOfWays + " entries per set using " + policy
				+ " entry replacement policy.");
		return new LinkedHashNWaySetCache<>(numOfWays, uniformNumOfEntries, policy, indexMapper);
	}
	
	private int getUniformNumOfEntries(int numOfEntries, int numOfWays) {
		int remainder = numOfEntries % numOfWays;
		if(remainder > 0) {
			numOfEntries -= remainder; 
		}
		return numOfEntries;
	}

	public static <K, V> LinkedHashNWaySetCacheBuilder<K, V> newBuilder(){
		return new LinkedHashNWaySetCacheBuilder<>();
	}

}
