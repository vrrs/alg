package com.vrrs.alg.cs.graphs;

import java.util.Objects;

public class Edge <T> {
	
	private final Vertex<T> _1;
	private final Vertex<T> _2;
	private final T item;
	private int weight;
	private int flow;

	public Edge(Vertex<T> _1, Vertex<T> _2, T item) {
		this._1 = _1;
		this._2 = _2;
		this.item = item;
	}
	public Edge(Vertex<T> _1, Vertex<T> _2) {
		this(_1, _2, null);
	}

	public Vertex<T> get_1() {
		return _1;
	}

	public Vertex<T> get_2() {
		return _2;
	}

	public T getItem() {
		return item;
	}
	@Override
	public int hashCode() {
		return Objects.hash(_1, _2);
	}
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object other) {
		if(other instanceof Edge) {
			Edge<T> that = (Edge<T>) other;
			return Objects.equals(this._1, that._1) && 
					Objects.equals(this._2, that._2);
		} else {
			return false;
		}
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getFlow() {
		return flow;
	}
	public void setFlow(int flow) {
		this.flow = flow;
	}
}
