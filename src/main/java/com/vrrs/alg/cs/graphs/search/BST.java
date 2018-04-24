package com.vrrs.alg.cs.graphs.search;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.vrrs.alg.cs.graphs.BTNode;

public class BST<E> {
	
	private final Comparator<E> cmp;
	private BTNode<E> root;

	public BST(Comparator<E> cmp) {
		this(cmp, null);
	}
	public BST(Comparator<E> cmp, BTNode<E> root) {
		this.cmp = cmp;
		this.root = root;
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
		}
	}

	public void remove(E elem) {
		BTNode<E> elemNode = find(elem);
		if (!elemNode.isEmpty()) {
			remove(elemNode);
		}
	}

	private void remove(BTNode<E> elemNode) {
		if (elemNode.isLeaf()) {
			if (elemNode.equals(root)) {
				root = null;
			} else {
				BTNode<E> parent = elemNode.getParent();
				if (parent.getRight() != null && parent.getRight().equals(elemNode)) {
					parent.setRight(null);
				} else {
					parent.setLeft(null);
				}
			}
		} else {
			BTNode<E> relative = null;
			if (elemNode.hasAtMostOneChild()) {
				relative = elemNode.getLeft() == null ? elemNode.getRight() : elemNode.getLeft();
			} else {
				relative = succ(elemNode);
			}
			swap(elemNode, relative);
			remove(relative);
		}
	}

	private void swap(BTNode<E> node, BTNode<E> otherNode) {
		E nodeItem = node.getItem();
		node.setItem(otherNode.getItem());
		otherNode.setItem(nodeItem);
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

	public BTNode<E> succ(E elem) {
		BTNode<E> elemNode = find(elem);
		return succ(elemNode);
	}
	
	private BTNode<E> succ(BTNode<E> elemNode) {
		BTNode<E> prev = null, cur = elemNode.getRight();
		while (cur != null) {
			prev = cur;
			cur = cur.getLeft();
		}
		return prev == null ? new BTNode<E>() : prev;	
	}
	
	public List<E> getInorderVisits() {
		//lvr --> rvl
		BiConsumer<Deque<BTNode<E>>,BTNode<E>> ops = (stack, node) -> {
			pushIfNotNull(stack, node.getRight());
			pushIfNotNull(stack, node);
			pushIfNotNull(stack, node.getLeft());
		};
		return getVisits(ops);
	}
	public List<E> getPreorderVisits() {
		//vlr --> rlv
		BiConsumer<Deque<BTNode<E>>,BTNode<E>> ops = (stack, node) -> {
			pushIfNotNull(stack, node.getRight());
			pushIfNotNull(stack, node.getLeft());
			pushIfNotNull(stack, node);
		};
		return getVisits(ops);
	}
	public List<E> getPostorderVisits() {
		//lrv --> vrl
		BiConsumer<Deque<BTNode<E>>,BTNode<E>> ops = (stack, node) -> {
			pushIfNotNull(stack, node);
			pushIfNotNull(stack, node.getRight());
			pushIfNotNull(stack, node.getLeft());
		};
		return getVisits(ops);
	}
	private void pushIfNotNull(Deque<BTNode<E>> stack, BTNode<E> node) {
		if(node != null)	stack.push(node);
	}
	private List<E> getVisits(BiConsumer<Deque<BTNode<E>>,BTNode<E>> ops){
		Set<BTNode<E>> expanded = new LinkedHashSet<>();
		List<E> visited = new ArrayList<>();
		final Deque<BTNode<E>> stack = new ArrayDeque<>();
		stack.push(root);
		Consumer<BTNode<E>> opsWithStack = node -> ops.accept(stack, node);
		while(!stack.isEmpty()) {
			BTNode<E> cur = stack.pop();
			if(expanded.contains(cur)) {
				visited.add(cur.getItem());
			} else {
				expanded.add(cur);
				opsWithStack.accept(cur);
			}
		}
		return visited;
	}

}
