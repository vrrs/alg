package com.vrrs.cache;

import java.util.function.Consumer;

@FunctionalInterface
public interface EvictionPolicy {

	<K, V> void apply(LinkedListHeader<K, V> header, Consumer<Integer> eviction);
	
	static final class LRUEviction implements EvictionPolicy {

		@Override
		public <K, V> void apply(LinkedListHeader<K, V> header, Consumer<Integer> eviction) {
			CacheEntry<K, V> head = header.getHead();
			CacheEntry<K, V> right = head.getRight();
			header.setHead(right);
			if(head == header.getTail()) header.setTail(right);
			if(right != null) right.setLeft(null);
			eviction.accept(head.getIndex());
		}
	}
	
	static final class MRUEviction implements EvictionPolicy {

		@Override
		public <K, V> void apply(LinkedListHeader<K, V> header, Consumer<Integer> eviction) {
			CacheEntry<K, V> tail = header.getTail();
			CacheEntry<K, V> left = tail.getLeft();
			header.setTail(left);
			if(tail == header.getHead()) header.setHead(left);
			if(left != null) left.setRight(null);
			eviction.accept(tail.getIndex());
		}

	}
}
