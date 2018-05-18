package com.vrrs.cache;

@FunctionalInterface
public interface EvictionPolicy {

	<K, V> void apply(CacheEntry<K, V> head);
}
