package com.vrrs.cache;

import java.util.function.Consumer;

@FunctionalInterface
public interface EvictionPolicy {

	<K, V> void apply(LinkedListHeader<K, V> head, Consumer<Integer> eviction);
}
