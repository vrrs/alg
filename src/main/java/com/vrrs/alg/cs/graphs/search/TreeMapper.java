package com.vrrs.alg.cs.graphs.search;

import java.util.ArrayDeque;
import java.util.Deque;

import com.vrrs.alg.cs.graphs.BTNode;

public class TreeMapper {

	public <E> int getHeight(BTNode<E> root) {
		Deque<BTNode<E>> stack = new ArrayDeque<>();
		int height = 0;
		stack.push(root);
		while (!stack.isEmpty()) {
			BTNode<E> node = stack.pop();
			if (node.getHeight() > height) {
				height = node.getHeight();
			}
			if (node.getRight() != null) {
				node.getRight().setHeight(node.getHeight() + 1);
				stack.push(node.getRight());
			}
			if (node.getLeft() != null) {
				node.getLeft().setHeight(node.getHeight() + 1);
				stack.push(node.getLeft());
			}
		}
		return height;
	}
}
