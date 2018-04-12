package com.vrrs.alg.cs.datastructures;

import java.util.List;
import java.util.Random;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;

public final class RandomArrayList<E> {

	private final ListMultimap<E, Integer> elemByIndex;
	private final List<E> elems;
	private final Random rand;

	public RandomArrayList(Random rand) {
		this.elemByIndex = LinkedListMultimap.create();
		this.elems = Lists.newArrayList();
		this.rand = rand;
	}

	public RandomArrayList() {
		this(new Random());
	}

	public boolean add(E elem) {
		int index = elems.size();
		elemByIndex.put(elem, index);
		return elems.add(elem);
	}

	public boolean remove(E elem) {
		if (elemByIndex.containsKey(elem)) {
			List<Integer> indexes = elemByIndex.get(elem);
			int lastIndexOfElem = indexes.get(indexes.size() - 1);
			if(lastIndexOfElem < elems.size() - 1) {
				E lastElem = elems.get(elems.size() - 1);
				elems.set(lastIndexOfElem, lastElem);
				List<Integer> lastElemIndexes = elemByIndex.get(lastElem);
				lastElemIndexes.set(lastElemIndexes.size() - 1, lastIndexOfElem);
			}
			elems.remove(elems.size() - 1);
			elemByIndex.remove(elem, lastIndexOfElem);
			return true;
		} else {
			return false;
		}
	}

	public E getRandom() {
		return elems.get(rand.nextInt(elems.size()));
	}
}
