package com.vrrs.alg.cs.graphs.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import com.vrrs.alg.cs.graphs.BTNode;

public class BTPath {
	
	public List<List<BTNode<Integer>>> getAllPaths(BTNode<Integer> root){
		List<List<BTNode<Integer>>> paths = new ArrayList<>();
		LinkedList<BTNode<Integer>> path = new LinkedList<>();
		findAllPaths(paths, path, root);
		return paths;
	}
	@SuppressWarnings("unchecked")
	private void findAllPaths(List<List<BTNode<Integer>>> paths, LinkedList<BTNode<Integer>> path,
			BTNode<Integer> cur) {
		path.add(cur);
		if(cur.isLeaf()) {
			paths.add((LinkedList<BTNode<Integer>>)path.clone());
		} else {
			if(cur.getLeft() != null) findAllPaths(paths, path, cur.getLeft());
			if(cur.getRight() != null) findAllPaths(paths, path, cur.getRight());
		}
		path.removeLast();
	}

}
