package com.vrrs.alg.problems.math;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

/**
 *  Problem: Given a collection of numbers, find the lowest common multiple. 
 *  
 *  Note: Due to the fact that Number class do not support arithmetic operations, 
 * type consistency is mantain only for Long, Integer, Float and Double types
 *
 * @author victor regalado
 */
public class LCMFinderSetImpl <T extends Number>{
	
	@SuppressWarnings("unchecked")
	private T multiply(T num1, int num2){
		Double value = num1.doubleValue() * num2;
		if(num1 instanceof Long)	return (T) Long.valueOf(value.longValue());
		if(num1 instanceof Integer)	return (T) Integer.valueOf(value.intValue());
		if(num1 instanceof Float)	return (T) Float.valueOf(value.floatValue());
		return (T) Double.valueOf(value);
	}



	private  boolean addAndTestMultiplicity(Multiset<T> multiset, T elem, int multiplicity) {
		multiset.add(elem);
		return multiset.count(elem) == multiplicity;
	}

	@SuppressWarnings("unchecked")
	public  T lowestCommonMultiple(T... elems) {
		Multiset<T> multiset = HashMultiset.create();
		int size = elems.length;
		T multiple; 
		for(int i = 1; i < Integer.MAX_VALUE; i++){
			for(T elem : elems){
				multiple = multiply(elem, i);
				if(addAndTestMultiplicity(multiset, multiple, size))
					return multiple;
			}
		}
		return null;
	}

}
