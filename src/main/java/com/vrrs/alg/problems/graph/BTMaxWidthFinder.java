package com.vrrs.alg.problems.graph;

import java.util.ArrayDeque;
import java.util.Deque;

import com.vrrs.alg.cs.graphs.BTNode;

public class BTMaxWidthFinder {
	
	public <E> int getMaxWidth(BTNode<E> root) {
		int maxWidth = 0;
		Deque<BTNode<E>> queue = new ArrayDeque<>();
		queue.addLast(root);
		while(!queue.isEmpty()) {
			int levelWidth = queue.size();
			for(int i = 0; i < levelWidth; i++)	{
				BTNode<E> node = queue.removeFirst();
				enqueueIfPresent(queue, node.getLeft());
				enqueueIfPresent(queue, node.getRight());
			}
			if(levelWidth > maxWidth)	maxWidth = levelWidth;
		}
		return maxWidth;
	}

	private <E> void enqueueIfPresent(Deque<BTNode<E>> queue, BTNode<E> node) {
		if(node != null)	queue.addLast(node);
	}

}
