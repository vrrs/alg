package com.vrrs.alg.cs.graphs;

import java.util.List;
import java.util.function.Supplier;

import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimaps;

public final class Graph <T> {
	
	private final List<Vertex<T>> vertices;
	private final List<Edge<T>> edges;

	private Graph(List<Vertex<T>> vertices, List<Edge<T>> edges) {
		this.vertices = vertices;
		this.edges = edges;
	}
	
	public List<Vertex<T>> getVertices(){
		return vertices;
	}
	
	public List<Edge<T>> getEdges(){
		return edges;
	}

	public static final class EdgeOrientedGraphBuilder<T> implements Supplier<Graph<T>> {
		
		private final List<Edge<T>> edges = Lists.newArrayList();
		
		public EdgeOrientedGraphBuilder<T> addEdge(Edge<T> edge) {
			this.edges.add(edge);
			return this;
		}
		public EdgeOrientedGraphBuilder<T> addEdge(Vertex<T> v1, Vertex<T> v2) {
			this.edges.add(new Edge<>(v1, v2, null));
			return this;
		}
		@Override
		public Graph<T> get() {
			return fromEdges(edges);
		}	
	}
	public static final class VertexOrientedGraphBuilder<T> implements Supplier<Graph<T>> {
		
		private final List<Vertex<T>> vertices = Lists.newArrayList();
		
		public VertexOrientedGraphBuilder<T> addVertex(Vertex<T> vertex) {
			this.vertices.add(vertex);
			return this;
		}
		@Override
		public Graph<T> get() {
			List<Edge<T>> edges = Lists.newArrayList();
			for(Vertex<T> vertex : vertices) {
				for(Vertex<T> child : vertex.getChildren()) {
					edges.add(new Edge<>(vertex, child));
				}
			}
			return fromEdges(edges);
		}	
	}
	private static <T> Graph<T> fromEdges(List<Edge<T>> edges){
		ListMultimap<Vertex<T>, Edge<T>> forwardEdgeMap = Multimaps.index(edges, edge -> edge.get_1());
		ListMultimap<Vertex<T>, Edge<T>> reverseEdgeMap = Multimaps.index(edges, edge -> edge.get_2());
		List<Vertex<T>> vertices = Lists.newArrayList(forwardEdgeMap.keySet());
		for(Vertex<T> vertex : vertices) {
			forwardEdgeMap.get(vertex).stream().map(e -> e.get_2()).forEach(v -> vertex.addChild(v));
			reverseEdgeMap.get(vertex).stream().map(e -> e.get_1()).forEach(v -> vertex.addParent(v));
		}
		return new Graph<>(vertices, edges);
	}
}
