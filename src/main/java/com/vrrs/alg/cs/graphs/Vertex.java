package com.vrrs.alg.cs.graphs;

import java.util.Collection;
import java.util.Set;

import com.google.common.collect.Sets;

public class Vertex <T> {
	
	private Color color = Color.WHITE;
	private Interval interval = new Interval();
	private Vertex<T> representative = this;
	private final Set<Vertex<T>> parents; 
	private final Set<Vertex<T>> children;
	private T item;
	private final Integer id;
	
	public Vertex(int id) {
		this(id, null, Sets.newLinkedHashSet(), Sets.newLinkedHashSet());
	}
	public Vertex(int id, T item) {
		this(id, item, Sets.newLinkedHashSet(), Sets.newLinkedHashSet());
	}
	public Vertex(int id, T item, Collection<Vertex<T>> parents, Collection<Vertex<T>> children) {
		this.id = id;
		this.item = item;
		this.parents = Sets.newLinkedHashSet(parents);
		this.children = Sets.newLinkedHashSet(children);
	}
	
	public Vertex<T> addParent(Vertex<T> parent) {
		this.parents.add(parent);
		return this;
	}
	
	public Set<Vertex<T>> getParents(){
		return parents;
	}
	public Vertex<T> addChild(Vertex<T> child) {
		this.children.add(child);
		return this;
	}
	public Set<Vertex<T>> getChildren(){
		return children;
	}

	public T getItem() {
		return item;
	}
	
	public boolean isEmpty() {
		return item == null;
	}
	
	public void setItem(T item) {
		this.item = item;
	}
	
	@Override
	public int hashCode() {
		return id.hashCode();
	}
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object other) {
		if(other instanceof Vertex) {
			Vertex<T> that = (Vertex<T>) other;
			return that.id.equals(this.id);
		} else {
			return false;
		}
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Interval getInterval() {
		return interval;
	}
	public void setInterval(Interval interval) {
		this.interval = interval;
	}
	public Vertex<T> getRepresentative() {
		return representative;
	}
	public void setRepresentative(Vertex<T> representative) {
		this.representative = representative;
	}
}