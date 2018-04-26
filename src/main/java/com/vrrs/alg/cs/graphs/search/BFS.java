package com.vrrs.alg.cs.graphs.search;

import java.util.Deque;
import java.util.Set;
import java.util.function.Consumer;

import com.google.common.collect.Queues;
import com.google.common.collect.Sets;
import com.vrrs.alg.cs.graphs.Graph;
import com.vrrs.alg.cs.graphs.Vertex;

public final class BFS<T> implements GraphTraverser<T> {
	
	public void traverse(Graph<T> graph, Consumer<Vertex<T>> visit){
		Set<Vertex<T>> visited = Sets.newLinkedHashSet();
		for(Vertex<T> vertex : graph.getVertices()) {
			if(!visited.contains(vertex)) {
				traverse(vertex, visited, visit);
			}
		}
	}

	private void traverse(Vertex<T> vertex, Set<Vertex<T>> visited, Consumer<Vertex<T>> visit) {
		Deque<Vertex<T>> vertexQueue = Queues.newArrayDeque();
		vertexQueue.push(vertex);
		while(!vertexQueue.isEmpty()) {
			Vertex<T> aVertex = vertexQueue.pollFirst();
			visit.accept(aVertex);
			visited.add(aVertex);
			for(Vertex<T> child : aVertex.getChildren()) {
				if(!visited.contains(child)) {
					vertexQueue.addLast(child);
				}
			}
		}
	}

}
