package com.vrrs.alg.problems.graph;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.vrrs.alg.cs.graphs.Vertex;

public class TestOneSourceOneDestinationDigraphSearch {
	
	@Test
	public void willReturnShortestPath() {
        /* Creates following Graph
        50
     /     \
    30      70
   /  \    /  \
  20<--40  60   80 */
		Vertex<Integer> root = new Vertex<>(50, 50);
		Vertex<Integer> v1 = new Vertex<>(30, 30);
		Vertex<Integer> v2 = new Vertex<>(70, 70);
		Vertex<Integer> dst = new Vertex<>(20, 20);
		Vertex<Integer> v3 = new Vertex<>(40, 40);
		Vertex<Integer> v4 = new Vertex<>(60, 60);
		Vertex<Integer> v5 = new Vertex<>(80, 80);
		root.addChild(v1);
		root.addChild(v2);
		v1.addChild(v3);
		v1.addChild(dst);
		v2.addChild(v4);
		v2.addChild(v5);
		v3.addChild(dst);
		
		OneSourceOneDestinationDigraphSearch search = new OneSourceOneDestinationDigraphSearch();
		List<Vertex<Integer>> shortestPath = search.getShortestPath(root, dst);
		assertThat(shortestPath)
		.containsExactly(root, v1, dst);
		
		List<List<Vertex<Integer>>> allPaths = search.getAllPaths(root, dst);
		assertThat(allPaths).contains(ImmutableList.of(root, v1, dst), 
				ImmutableList.of(root, v1, v3, dst));
	}

}
