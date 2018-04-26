package com.vrrs.alg.cs.graphs.search;

import java.util.Comparator;

import com.vrrs.alg.cs.graphs.BTNode;
import com.vrrs.alg.cs.graphs.Color;

public class RBT <E> {
	
	private final Comparator<E> cmp;
	private BTNode<E> root;
	private final TreeRotator rotator;

	public RBT(Comparator<E> cmp) {
		this(cmp, null);
	}
	public RBT(Comparator<E> cmp, BTNode<E> root) {
		this.cmp = cmp;
		this.root = root;
		this.rotator = new TreeRotator();
	}
	public BTNode<E> getRoot(){
		return root;
	}
	public Comparator<E> getComparator(){
		return cmp;
	}
	
	public void add(E elem) {
		BTNode<E> elemNode = find(elem);
		if (elemNode.isEmpty()) {
			elemNode.setItem(elem);
			BTNode<E> parent = elemNode.getParent();
			if (parent == null) {
				root = elemNode;
			} else if (cmp.compare(parent.getItem(), elem) == 1) {
				parent.setLeft(elemNode);
			} else {
				parent.setRight(elemNode);
			}
			elemNode.setColor(Color.RED);
			addFixUp(elemNode);
		}
	}
	
	private void addFixUp(BTNode<E> elemNode) {
		BTNode<E> cur = elemNode;
		while(cur.getParent() != null && cur.getParent().getColor() == Color.RED) {
			BTNode<E> grandpa = cur.getParent().getParent();
			if(grandpa == null) break;
			if(cur.getParent().equals(grandpa.getLeft())){
				BTNode<E> uncle = grandpa.getRight();
				if(uncle != null && uncle.getColor() == Color.RED) {
					uncle.setColor(Color.BLACK);
					cur.getParent().setColor(Color.BLACK);
					grandpa.setColor(Color.RED);
					cur = grandpa;
				} else {
					if(cur.equals(cur.getParent().getRight())) {
						cur = cur.getParent();
						cur = rotator.rotateLeft(cur);
					}
					cur.getParent().setColor(Color.BLACK);
					grandpa.setColor(Color.RED);
					rotator.rotateRight(grandpa);
				}
			} else {
				BTNode<E> uncle = grandpa.getLeft();
				if(uncle != null && uncle.getColor() == Color.RED) {
					uncle.setColor(Color.BLACK);
					cur.getParent().setColor(Color.BLACK);
					grandpa.setColor(Color.RED);
					cur = grandpa;
				} else {
					if(cur.equals(cur.getParent().getLeft())) {
						cur = cur.getParent();
						cur = rotator.rotateRight(cur);
					}
					cur.getParent().setColor(Color.BLACK);
					grandpa.setColor(Color.RED);
					rotator.rotateLeft(grandpa);
				}
			}
		}
		root.setColor(Color.BLACK);
	}
	public BTNode<E> find(E elem) {
		BTNode<E> prev = null, cur = root;
		while (cur != null) {
			if (cmp.compare(cur.getItem(), elem) == 0)	return cur;
			prev = cur;
			if (cmp.compare(cur.getItem(), elem) == 1) {
				cur = cur.getLeft();
			} else {
				cur = cur.getRight();
			}
		}
		BTNode<E> elemNode = new BTNode<>();
		elemNode.setParent(prev);
		return elemNode;
	}
	
	public void remove(E elem) {
		
	}

}
