package com.vrrs.alg.cs.datastructures;

import com.vrrs.alg.cs.graphs.Vertex;

public interface UnionFind<T> {
	
	Vertex<T> find(Vertex<T> elem);
	Vertex<T> makeset(Vertex<T> elem);
	void union(Vertex<T> elem1, Vertex<T> elem2);
}
