package com.vrrs.cache;

final class LinkedListHeader <K, V> {
	
	private int listSize;
	private CacheEntry<K, V> head;
	private CacheEntry<K, V> tail;
	
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
	public int getListSize() {
		return listSize;
	}

	public void setListSize(int listSize) {
		this.listSize = listSize;
	}
}
