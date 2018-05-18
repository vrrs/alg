package com.vrrs.cache;

@FunctionalInterface
public interface EvictionPolicy {

	<K, V> void apply(LinkedListHeader<K, V> head);
}
