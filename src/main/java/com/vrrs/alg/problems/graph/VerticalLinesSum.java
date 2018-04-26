package com.vrrs.alg.problems.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import com.vrrs.alg.cs.graphs.BTNode;

public class VerticalLinesSum {
	
	public int[] getVerticalLinesSum(BTNode<Integer> root) {
		Deque<BTNode<Integer>> stack = new ArrayDeque<>();
		stack.push(root);
		Map<Integer, Integer> sumByLabel = new HashMap<>();
		int minLabel = 0;
		while (!stack.isEmpty()) {
			BTNode<Integer> node = stack.pop();
			if(node.getParent() != null) {
				int parentLabel = node.getParent().getLabel();
				if(node.equals(node.getParent().getLeft())) {
					node.setLabel(parentLabel - 1);
				} else {
					node.setLabel(parentLabel + 1);
				}
			}
			if(node.getLabel() < minLabel)	minLabel = node.getLabel();
			Integer sum = sumByLabel.get(node.getLabel());
			sum = (sum == null) ? 0 : sum;
			sumByLabel.put(node.getLabel(), sum + node.getItem());
			if (node.getRight() != null)	stack.push(node.getRight());
			if (node.getLeft() != null)		stack.push(node.getLeft());
		}
		minLabel = (int) Math.abs(minLabel);
		int[] sums = new int[sumByLabel.size()];
		for (Map.Entry<Integer, Integer> entry : sumByLabel.entrySet()) {
			sums[entry.getKey() + minLabel] = entry.getValue();
		}
		return sums;
	}
}
