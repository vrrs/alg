package com.vrrs.alg.cs.graphs.search;

import java.util.function.Consumer;

import com.vrrs.alg.cs.graphs.Graph;
import com.vrrs.alg.cs.graphs.Vertex;

@FunctionalInterface
public interface GraphTraverser<T> {
	
	void traverse(Graph<T> graph, Consumer<Vertex<T>> visit);

}
