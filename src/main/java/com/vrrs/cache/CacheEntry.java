package com.vrrs.cache;

final class CacheEntry <K, V> {
	
	private final K key;
	private final V value;
	private CacheEntry<K, V> left;
	private CacheEntry<K, V> right;
	private CacheEntry<K, V> head;
	private CacheEntry<K, V> tail;
	private final int index;
	private int listSize;
	
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

	public CacheEntry<K, V> getHead() {
		return head;
	}

	public void setHead(CacheEntry<K, V> head) {
		this.head = head;
	}

	public CacheEntry<K, V> getTail() {
		return tail;
	}

	public void setTail(CacheEntry<K, V> tail) {
		this.tail = tail;
	}
	
	public static <K, V> CacheEntry<K, V> newValueLessEntry(){
		return new CacheEntry<>(null, null, -1);
	}

	public int getIndex() {
		return index;
	}

	public int getListSize() {
		return listSize;
	}

	public void setListSize(int listSize) {
		this.listSize = listSize;
	}
}
