package com.vrrs.cache;

import java.util.function.Consumer;

final class LRUEviction implements EvictionPolicy {

	@Override
	public <K, V> void apply(LinkedListHeader<K, V> head, Consumer<Integer> eviction) {
		// TODO Auto-generated method stub
		
	}
}
