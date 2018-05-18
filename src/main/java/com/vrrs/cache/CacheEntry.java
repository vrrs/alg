package com.vrrs.cache;

final class CacheEntry <K, V> {
	
	private final K key;
	private final V value;
	private CacheEntry<K, V> left;
	private CacheEntry<K, V> right;
	private final int index;
	
	public CacheEntry(K key, V value, int index) {
		this.key = key;
		this.value = value;
		this.index = index;
	}

	public K getKey() {
		if(key == null) throw new UnsupportedOperationException();
		return key;
	}

	public V getValue() {
		if(value == null) throw new UnsupportedOperationException();
		return value;
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
	
	public static <K, V> CacheEntry<K, V> newValueLessEntry(){
		return new CacheEntry<>(null, null, -1);
	}

	public int getIndex() {
		return index;
	}
}
