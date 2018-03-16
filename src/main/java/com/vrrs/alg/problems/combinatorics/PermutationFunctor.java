package com.vrrs.alg.problems.combinatorics;

import java.util.List;
import java.util.Set;
import java.util.function.Function;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public final class PermutationFunctor <T> implements Function<List<T>, Set<List<T>>> {

	@Override
	public Set<List<T>> apply(List<T> elems) {
		Set<List<T>> permutations = Sets.newLinkedHashSet();
		for (int i = 0; i < elems.size(); i++) {
			permutations = permutate(elems.get(i), permutations, i + 1);
		}
		return permutations;
	}

	private Set<List<T>> permutate(T elem, Set<List<T>> permutations, int size) {
		Set<List<T>> newPermutations = Sets.newLinkedHashSet();
		if(permutations.isEmpty()) {
			newPermutations.add(ImmutableList.of(elem));
		} else {
			for(List<T> permutation : permutations) { 
				for(int position = 0; position < size; position++) {
					newPermutations.add(mergeAt(elem, permutation, position));
				}
			}
		}
		return newPermutations;
	}

	private List<T> mergeAt(T elem, List<T> permutation, int position) {
		List<T> newPermutation = Lists.newLinkedList(permutation);
		newPermutation.add(position, elem);
		return newPermutation;
	}

}
