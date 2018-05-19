package com.vrrs.cache;

import java.util.function.Supplier;

public final class LinkedHashNWayCacheBuilder<K, V> implements Supplier<Cache<K, V>> {

	public enum CacheEvictionPolicy {
		LRU(new EvictionPolicy.LRUEviction()),
		MRU(new EvictionPolicy.MRUEviction());
		
		private final EvictionPolicy policy;
		
		CacheEvictionPolicy(EvictionPolicy policy){
			this.policy = policy;
		}
		public EvictionPolicy getPolicy() {
			return policy;
		}
	}
	
	private int numOfWays;
	private int numOfEntries;
	private EvictionPolicy policy;
	private IndexMapper<K, V> indexMapper;
	
	public LinkedHashNWayCacheBuilder<K, V> withNumOfWays(int numOfWays) {
		this.numOfWays = numOfWays;
		return this;
	}

	public LinkedHashNWayCacheBuilder<K, V> withNumOfEntries(int numOfEntries) {
		this.numOfEntries = numOfEntries;
		return this;
	}

	public LinkedHashNWayCacheBuilder<K, V> withPolicy(CacheEvictionPolicy cacheEvictionPolicy) {
		this.policy = cacheEvictionPolicy.getPolicy();
		return this;
	}

	LinkedHashNWayCacheBuilder<K, V> withIndexMapper(IndexMapper<K, V> indexMapper) {
		this.indexMapper = indexMapper;
		return this;
	}

	@Override
	public Cache<K, V> get() {
		if(numOfWays == 0 || numOfEntries == 0 || policy == null) {
			throw new IllegalArgumentException("Number of ways and entries, as well as policy must be set.");
		}
		if(indexMapper == null) indexMapper = new IndexMapper.MultiHashIndexMapper<>(numOfWays);
		return new LinkedHashNWaySetCache<>(numOfWays, numOfEntries, policy, indexMapper);
	}
	
	public static <K, V> LinkedHashNWayCacheBuilder<K, V> newBuilder(){
		return new LinkedHashNWayCacheBuilder<>();
	}

}
