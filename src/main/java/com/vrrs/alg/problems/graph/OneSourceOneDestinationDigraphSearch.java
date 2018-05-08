package com.vrrs.alg.problems.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import com.vrrs.alg.cs.graphs.Edge;
import com.vrrs.alg.cs.graphs.Vertex;

public class OneSourceOneDestinationDigraphSearch {
	
	public List<Vertex<Integer>> getShortestPath(Vertex<Integer> src, Vertex<Integer> dst){
		Set<Vertex<Integer>> path = new LinkedHashSet<>();
		Queue<Vertex<Integer>> queue = new PriorityQueue<>((x,y) -> 
			x.getItem() == y.getItem() ? 0 : (x.getItem() > y.getItem() ? 1 : -1));
		queue.add(src);
		while(!queue.isEmpty()) {
			Vertex<Integer> cur = queue.poll();
			path.add(cur);
			if(cur.equals(dst)) {
				return new ArrayList<>(path);
			} else {
				for(Vertex<Integer> child : cur.getChildren()) {
					if(!path.contains(child)) {
						queue.add(child);
					}
				}
			}
		}
		return new ArrayList<>();
	}
	
	public List<List<Vertex<Integer>>> getAllPaths(Vertex<Integer> src, Vertex<Integer> dst){
		List<List<Vertex<Integer>>> allPaths = new ArrayList<>();
		Set<Vertex<Integer>> path = new LinkedHashSet<>();
		Queue<Vertex<Integer>> queue = new PriorityQueue<>((x,y) -> 
			x.getItem() == y.getItem() ? 0 : (x.getItem() > y.getItem() ? 1 : -1));
		queue.add(src);
		while(!queue.isEmpty()) {
			Vertex<Integer> cur = queue.poll();
			path.add(cur);
			if(cur.equals(dst)) {
				allPaths.add(new ArrayList<>(path));
				path.remove(cur);
			} else {
				for(Vertex<Integer> child : cur.getChildren()) {
					if(!path.contains(child)) {
						queue.add(child);
					}
				}
			}
		}
		return allPaths;
	}
	
	public List<List<Vertex<Integer>>> getAllTours(Vertex<Integer> src,Vertex<Integer> dst){
		List<List<Vertex<Integer>>> allTours = new ArrayList<>();
		Deque<Edge<Integer>> stack = new ArrayDeque<>();
		Set<Edge<Integer>> path = new LinkedHashSet<>();
		addEdgesIfNotVisited(stack, path, src);
		while(!stack.isEmpty()) {
			Edge<Integer> edge = stack.pop();
			path.add(edge); // visit
			Vertex<Integer> endpoint = edge.get_2();
			if(endpoint.equals(dst)) {
				allTours.add(toVertexPath(src, path));
				path.remove(edge);
			} else {
				if(!addEdgesIfNotVisited(stack, path, endpoint)) path.remove(edge);
			}
		}
		return allTours;
	}

	private boolean addEdgesIfNotVisited(Deque<Edge<Integer>> stack, Set<Edge<Integer>> path, Vertex<Integer> endpoint) {
		boolean edgesWerePushed = false;
		for(Vertex<Integer> child : endpoint.getChildren()) {
			Edge<Integer> curEdge = new Edge<>(endpoint, child);
			if(!path.contains(curEdge)) {
				stack.push(curEdge);
				edgesWerePushed = true;
			}
		}
		return edgesWerePushed;	
	}

	private List<Vertex<Integer>> toVertexPath(Vertex<Integer> src, Set<Edge<Integer>> path) {
		List<Vertex<Integer>> vertexPath = new ArrayList<>();
		vertexPath.add(src);
		for(Edge<Integer> edge : path) {
			vertexPath.add(edge.get_2());
		}
		return vertexPath;
	}

}
