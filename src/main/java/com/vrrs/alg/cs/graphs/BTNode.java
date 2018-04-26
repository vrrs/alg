package com.vrrs.alg.cs.graphs;

public class BTNode <E>{
	
	private BTNode<E> left;
	private BTNode<E> right;
	private BTNode<E> parent;
	private Color color = Color.BLACK;
	private E item;
	private int height = 1;
	private int label = 0;
	
	public BTNode(E item) {
		this.item = item;
	}
	
	public BTNode() {
		this(null);
	}
	
	public Color getColor(){
		return color;
	}
	public void setColor(Color color){
		this.color = color;
	}
	
	public boolean isEmpty() {
		return item == null;
	}
	
	public BTNode<E> getLeft() {
		return left;
	}
	public void setLeft(BTNode<E> left) {
		this.left = left;
	}
	public BTNode<E> getRight() {
		return right;
	}
	public void setRight(BTNode<E> right) {
		this.right = right;
	}
	public BTNode<E> getParent() {
		return parent;
	}
	public void setParent(BTNode<E> parent) {
		this.parent = parent;
	}
	public E getItem() {
		return item;
	}
	public void setItem(E item) {
		this.item = item;
	}
	public boolean isLeaf() {
		return left == null && right == null;
	}
	public boolean hasAtMostOneChild() {
		return !isLeaf() && (left == null || right == null);
	}
	@Override
	public int hashCode() {
		return item == null ? 0 : item.hashCode();
	}
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object other) {
		if(other != null && other instanceof BTNode) {
			BTNode<E> that = (BTNode<E>) other;
			if(this.isEmpty()) {
				return that.isEmpty();
			} else {
				return !that.isEmpty() && that.item.equals(this.item);
			}
		} else {
			return false;
		}
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getLabel() {
		return label;
	}

	public void setLabel(int label) {
		this.label = label;
	}

}
