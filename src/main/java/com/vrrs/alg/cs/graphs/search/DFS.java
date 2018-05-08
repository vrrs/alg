package com.vrrs.alg.cs.graphs.search;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

import com.google.common.collect.Queues;
import com.google.common.collect.Sets;
import com.vrrs.alg.cs.graphs.Graph;
import com.vrrs.alg.cs.graphs.Vertex;

public class DFS<T> implements GraphTraverser<T> {

	public void traverse(Graph<T> graph, Consumer<Vertex<T>> visit){
		Set<Vertex<T>> visited = Sets.newLinkedHashSet();
		Set<Vertex<T>> discoveredVertices = new LinkedHashSet<>();
		Map<Vertex<T>, Integer> startTimeByVertex = new HashMap<>();
		Map<Vertex<T>, Integer> endTimeByVertex = new HashMap<>();
		int time = 0;
		for(Vertex<T> vertex : graph.getVertices()) {
			if(!visited.contains(vertex)) {
				time = traverse(vertex, visited, visit, time, discoveredVertices, startTimeByVertex, endTimeByVertex);
			}
		}
	}

	private int traverse(Vertex<T> root, Set<Vertex<T>> visited, Consumer<Vertex<T>> visit, int time, Set<Vertex<T>> discoveredVertices, Map<Vertex<T>, Integer> startTimeByVertex, Map<Vertex<T>, Integer> endTimeByVertex) {	
		Deque<Vertex<T>> stack = Queues.newArrayDeque();
		stack.push(root);
		while(!stack.isEmpty()) {
			Vertex<T> aVertex = stack.pop();
			if(visited.contains(aVertex)) {
				endTimeByVertex.put(aVertex, ++time); continue;
			} else {
				visit.accept(aVertex);
				visited.add(aVertex);
				startTimeByVertex.put(aVertex, ++time);
				stack.push(aVertex);
			}
			for(Vertex<T> child : aVertex.getChildren()) {
				if(!discoveredVertices.contains(child)) {
					discoveredVertices.add(child);
					stack.push(child);// tree edge
				} else if(!visited.contains(child)) {
					// back edge no push
				} else if (startTimeByVertex.get(child) > startTimeByVertex.get(aVertex)) {
					// forward no push
				} else {
					// cross edge no push
				}
			}
		}
		return time;
	}

}
