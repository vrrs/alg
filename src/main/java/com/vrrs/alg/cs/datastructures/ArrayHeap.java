package com.vrrs.alg.cs.datastructures;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ArrayHeap <E> {
	
	private final Comparator<E> cmp;
	private final List<E> elems;

	public ArrayHeap(Comparator<E> cmp) {
		this.cmp = cmp;
		this.elems = new ArrayList<E>();
	}
	
	public ArrayHeap() {
		this((x,y) -> x.equals(y) ? 0 : (x.hashCode() > y.hashCode() ? 1 : 0));
	}
	
	public void add(E elem) {
		elems.add(elem);
		shiftUp(elems.size() - 1);
	}
	
	private void shiftUp(int i) {
		int parent = (int) Math.ceil(i / 2.0) - 1;
		int child = i;
		while(parent >= 0) {
			if(cmp.compare(elems.get(parent), elems.get(child)) != 1) {
				swap(parent, child);
			} else {
				break;
			}
			child = parent;
			parent = (int) Math.ceil(child / 2.0) - 1;
		}
	}

	public E pollHead() {
		E head = elems.get(0);
		swap(0, elems.size() - 1);
		elems.remove(elems.size() - 1);
		shiftDown(0);
		return head;
	}

	private void shiftDown(int i) {
		int parent = i;
		int leftChild = parent*2 + 1;
		while (leftChild < elems.size()) {
			int rightChild = leftChild + 1;
			rightChild = rightChild >= elems.size() ? leftChild : rightChild;
			int child = cmp.compare(elems.get(leftChild), elems.get(rightChild)) == 1 ? 
					leftChild : rightChild;
			if(cmp.compare(elems.get(parent), elems.get(child)) != 1) {
				swap(parent, child);
			} else {
				break;
			}
			parent = child;
			leftChild = parent*2 + 1;
		}
	}

	private void swap(int i, int j) {
		E tmp = elems.get(i);
		elems.set(i, elems.get(j));
		elems.set(j, tmp);
	}

}
