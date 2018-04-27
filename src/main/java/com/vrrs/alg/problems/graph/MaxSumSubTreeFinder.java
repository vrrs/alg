package com.vrrs.alg.problems.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

import com.vrrs.alg.cs.graphs.BTNode;

public class MaxSumSubTreeFinder {

	public int find(BTNode<Integer> root) {
		int maxSum = 0;
		Deque<BTNode<Integer>> stack = new ArrayDeque<>();
		stack.push(root);
		Set<BTNode<Integer>> expanded = new HashSet<>();
		while(!stack.isEmpty()) {
			BTNode<Integer> node = stack.pop();
			if(expanded.contains(node)) {
				int leftSum = node.getLeft() == null ? 0 : node.getLeft().getLabel();
				int rightSum = node.getRight() == null ? 0 : node.getRight().getLabel();
				node.setLabel(node.getItem() + leftSum + rightSum);
				if(!node.equals(root) && node.getLabel() > maxSum) maxSum = node.getLabel(); 
			} else {
				expanded.add(node);//lrv --> vrl
				stack.push(node);
				pushIfPresent(stack, node.getRight());
				pushIfPresent(stack, node.getLeft());
			}
		}
		return maxSum;
	}

	private void pushIfPresent(Deque<BTNode<Integer>> stack, BTNode<Integer> node) {
		if(node != null) stack.push(node);
	}
}
