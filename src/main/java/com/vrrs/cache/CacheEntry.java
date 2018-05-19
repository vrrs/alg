package com.vrrs.cache;

final class CacheEntry <K, V> {
	
	private final K key;
	private final V value;
	private final int index;
	
	private CacheEntry<K, V> left;
	private CacheEntry<K, V> right;

	public CacheEntry(K key, V value, int index) {
		this.key = key;
		this.value = value;
		this.index = index;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}
	
	public int getIndex() {
		return index;
	}

	public CacheEntry<K, V> getLeft() {
		return left;
	}

	public void setLeft(CacheEntry<K, V> left) {
		this.left = left;
	}

	public CacheEntry<K, V> getRight() {
		return right;
	}

	public void setRight(CacheEntry<K, V> right) {
		this.right = right;
	}
}
