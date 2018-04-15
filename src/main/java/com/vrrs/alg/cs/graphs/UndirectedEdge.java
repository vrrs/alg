package com.vrrs.alg.cs.graphs;

import java.util.Objects;

public class UndirectedEdge <T> extends Edge<T> {

	public UndirectedEdge(Vertex<T> _1, Vertex<T> _2, T item) {
		super(_1, _2, item);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object other) {
		if(other instanceof Edge) {
			Edge<T> that = (Edge<T>) other;
			return Objects.equals(this.get_1(), that.get_1()) && 
					Objects.equals(this.get_2(), that.get_2()) || 
						Objects.equals(this.get_1(), that.get_2()) && 
							Objects.equals(this.get_2(), that.get_1());
		} else {
			return false;
		}
	}

}
