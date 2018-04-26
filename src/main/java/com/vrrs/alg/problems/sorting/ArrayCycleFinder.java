package com.vrrs.alg.problems.sorting;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.vrrs.alg.cs.graphs.BTNode;

public class ArrayCycleFinder {
	
	public boolean hasCycle(int[] elems) {
		Map<Integer, BTNode<Integer>> nodeById = getNodesById(elems);
		BTNode<Integer> root = nodeById.get(0);
		Set<BTNode<Integer>> expanded = new HashSet<>();
		Deque<BTNode<Integer>> stack = new ArrayDeque<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			BTNode<Integer> node = stack.pop();
			if(expanded.contains(node)) {
				if(node.getParent() == null || !node.getParent().equals(node)) return true;
			} else {
				expanded.add(node);
				pushIfPresent(stack, node.getLeft());
			}
		}
		return false;
	}

	private Map<Integer, BTNode<Integer>> getNodesById(int[] elems) {
		Map<Integer, BTNode<Integer>> nodeById = new HashMap<>();
		for(int i = 0; i < elems.length; i++) {
			BTNode<Integer> parent = getNode(nodeById, i);
			BTNode<Integer> child = getNode(nodeById, (i + elems[i]) % elems.length);
			parent.setLeft(child);
			child.setParent(parent);
		}
		return nodeById;
	}

	private BTNode<Integer> getNode(Map<Integer, BTNode<Integer>> nodeById, int id) {
		BTNode<Integer> node = nodeById.get(id);
		if(node == null) {
			node = new BTNode<>(id);
			nodeById.put(id, node);
		}
		return node;
	}

	private void pushIfPresent(Deque<BTNode<Integer>> stack, BTNode<Integer> node) {
		if(node != null) stack.push(node);
	}

}
