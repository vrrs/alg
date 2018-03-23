package com.vrrs.alg.problems.sorting;

import java.util.Comparator;
import java.util.List;

public final class BinarySearcher <T> {
	
	private final Comparator<T> cmp;

	public BinarySearcher(Comparator<T> cmp) {
		this.cmp = cmp;
	}
	
	public int getLowerBound(List<T> elems, T elem) {
		return getBound(elems, elem, -1, 0, elems.size() - 1);
	}
	
	public int getUpperBound(List<T> elems, T elem) {
		return getBound(elems, elem, 1, 0, elems.size() - 1) - 1;
	}
	
	public int find(List<T> elems, T elem) {
		return getBound(elems, elem, 0, 0, elems.size() - 1);
	}

	private int getBound(List<T> elems, T elem, int compare, int lowerBound ,int upperBound){
		if(lowerBound > upperBound) {
			if(compare == 0) {
				return -1;
			} else {
				return lowerBound;
			}
		}
		int middle = (upperBound + lowerBound) / 2;
		if(cmp.compare(elems.get(middle), elem) == 0 && compare == 0) {
			return middle;
		}
		if(cmp.compare(elems.get(middle), elem) == 0 && compare == -1) {
			return getBound(elems, elem, compare, lowerBound, middle - 1);
		} 
		if(cmp.compare(elems.get(middle), elem) == 1) {
			return getBound(elems, elem, compare, lowerBound, middle - 1);
		} else {
			return getBound(elems, elem, compare, middle + 1, upperBound);
		}
	}

}
