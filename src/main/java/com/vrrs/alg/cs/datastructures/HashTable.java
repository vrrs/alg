package com.vrrs.alg.cs.datastructures;

import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

/**
 * Hashtable implemented collision resolution by chaining using circular doubly linked list
 * and fixed size capacity 
 * @author victor regalado
 *
 */
public final class HashTable <T> implements Set<T> {
	
	private class Node {
		private Node next;
		private Node prev;
		private final Object item;
		
		Node(Object item){
			this.item = item;
			this.next = this;
			this.prev = this;
		}
		@Override
		public int hashCode() {
			return item.hashCode();
		}
		@Override
		public boolean equals(Object other) {
			if(other instanceof HashTable.Node) {
				@SuppressWarnings("unchecked")
				Node that = (Node) other;
				return this.item.equals(that.item);
			} else {
				return false;
			}
		}
	}
	
	private Node[] buckets;
	private int capacity;
	private final double loadFactor;
	private int size;
	
	@SuppressWarnings("unchecked")
	public HashTable(int initialCapacity, double loadFactor) {
		this.capacity = initialCapacity;
		this.buckets = new HashTable.Node[initialCapacity];
		this.size = 0;
		this.loadFactor = loadFactor;
	}
	public HashTable(int initialCapacity) {
		this(initialCapacity, 0.75);
	}
	private Optional<Node> findNode(Node head, Node node) {
		Node cur = head;
		while(cur.next != head) {
			if(cur.equals(node)) {
				break;
			}
			cur = cur.next;
		}
		if(cur.equals(node)) {
			return Optional.of(cur);
		} else {
			return Optional.empty();
		}
	}

	@Override
	public boolean add(T elem) {
		Node elemNode = new Node(elem);
		Node bucketHead = buckets[elemNode.hashCode() % buckets.length];
		if (bucketHead == null) {
			buckets[elemNode.hashCode() % buckets.length] = elemNode;
			increaseSize();
			return true;
		} else {
			return add(bucketHead, elemNode);
		}
	}

	private void increaseSize() {
		size++;
		if(size >= loadFactor * capacity) {
			rehashing();
		}
	}
	@SuppressWarnings("unchecked")
	private void rehashing() {
		capacity = 2 * capacity;
		Node[] newBuckets = new HashTable.Node[capacity];
		for(int i = 0; i < buckets.length; i++) {
			if(buckets[i] != null) {
				newBuckets[buckets[i].hashCode() % capacity] = buckets[i];
			}
		}
		this.buckets = newBuckets;
	}

	private boolean add(Node bucketHead, Node elemNode) {
		Optional<Node> foundElemNode = findNode(bucketHead, elemNode);
		if (foundElemNode.isPresent()) {
			return false;
		} else {
			Node bucketTail = bucketHead.prev;
			bucketTail.next = elemNode;
			elemNode.prev = bucketTail;
			elemNode.next = bucketHead;
			bucketHead.prev = elemNode;
			increaseSize();
			return true;
		}
	}

	@Override
	public boolean addAll(Collection<? extends T> elems) {
		boolean changed = false;
		for(T elem : elems) {
			if(add(elem) && !changed) changed = true;
		}
		return changed;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		this.buckets = new HashTable.Node[capacity];
		this.size = 0;
	}

	@Override
	public boolean contains(Object elem) {
		Node elemNode = new Node(elem);
		Node bucketHead = buckets[elemNode.hashCode() % buckets.length];
		if (bucketHead == null) {
			return false;
		} else {
			return findNode(bucketHead, elemNode).isPresent();
		}
	}

	@Override
	public boolean containsAll(Collection<?> elems) {
		for(Object elem : elems) {
			if(!contains(elem))	return false;
		}
		return true;
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public boolean remove(Object elem) {
		Node elemNode = new Node(elem);
		Node bucketHead = buckets[elemNode.hashCode() % buckets.length];
		if (bucketHead == null) {
			return false;
		} else if (elemNode.equals(bucketHead)) {
			buckets[elemNode.hashCode() % buckets.length] = null;
			size--;
			return true;
		} else {
			return remove(bucketHead, elemNode);
		}
	}

	private boolean remove(Node bucketHead, Node elemNode) {
		Optional<Node> foundElemNode = findNode(bucketHead, elemNode);
		if (foundElemNode.isPresent()) {
			Node theElem = foundElemNode.get();
			Node prev = theElem.prev;
			Node next = theElem.next;
			prev.next = next;
			next.prev = prev;
			size--;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean removeAll(Collection<?> elems) {
		boolean changed = true;
		for(Object elem : elems) {
			if(!remove(elem) && changed) changed = false;
		}
		return changed;
	}

	@Override
	public boolean retainAll(Collection<?> elems) {
		boolean changed = false;
		for(Object elem : toArray()) {
			if(!elems.contains(elem)) {
				if(remove(elem) && !changed)	changed = true;
			}
		}
		return changed;
	}

	@Override
	public int size() {
		return this.size;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private int index = 0;
			private int bucketIndex = 0;
			@Override
			public boolean hasNext() {
				Node bucketHead = buckets[bucketIndex];
				Node nextNode = findNode().next;
				if(nextNode.equals(bucketHead)) {
					if(bucketIndex + 1 < capacity) {
						return buckets[bucketIndex + 1] != null;
					} else {
						return false;
					}
				} else {
					return true;
				}
			}

			@SuppressWarnings("unchecked")
			@Override
			public T next() {
				Node bucketHead = buckets[bucketIndex];
				Node nextNode = findNode().next;
				if (nextNode.equals(bucketHead)) {
					bucketIndex++;
					index = 0;
				} else {
					index++;
				}
				return (T) nextNode.item;
			}
			private Node findNode() {
				Node bucketHead = buckets[bucketIndex];
				Node cur = bucketHead;
				for(int i = 0; i < index; i++) {
					cur = cur.next;
				}
				if(index == 0) {
					return bucketHead;
				} else {
					return cur;
				}
			}
		};
	}

	@Override
	public Object[] toArray() {
		Object[] ar = new Object[size];
		Iterator<T> iter = iterator();
		for(int i = 0; i < ar.length && i < size; i++) {
			ar[i] = iter.next();
		}
		return ar;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <S> S[] toArray(S[] ar) {
		Iterator<T> iter = iterator();
		for(int i = 0; i < ar.length && i < size; i++) {
			ar[i] = (S) iter.next();
		}
		return ar;
	}

}
