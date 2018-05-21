package com.vrrs.cache;

import java.util.Optional;

public interface Cache <K, V> {
	
	Optional<V> get(K key);
	void put(K key, V value);
	
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
	
}
