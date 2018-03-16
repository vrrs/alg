package com.vrrs.alg.problems.combinatorics;

import org.apache.commons.math.util.MathUtils;
import org.junit.Test;
import com.google.common.collect.ImmutableList;
import com.vrrs.alg.problems.combinatorics.PermutationFunctor;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Set;
import static java.util.stream.Collectors.toSet;

public class TestPermutationFunctor {
	
	@Test
	public void willPermutateListOfElements(){
		List<String> listOfElems = ImmutableList.of("a", "b", "c");
		Set<List<String>> permutations = new PermutationFunctor<String>().apply(listOfElems);
		int expectedNumOfPermutations = (int)MathUtils.factorial(listOfElems.size());
		int actualUniqueNumOfPermutations = permutations.stream().map(List::hashCode).collect(toSet()).size();
		
		assertThat(permutations).hasSize(expectedNumOfPermutations)
			.hasSize(actualUniqueNumOfPermutations)
			.allMatch(permutation -> permutation.size() == listOfElems.size());
		
		Set<String> actualElemsOfPermutations = permutations.stream().flatMap(l -> l.stream()).collect(toSet());
		assertThat(actualElemsOfPermutations).hasSameSizeAs(listOfElems);
	}
	
	@Test
	public void willPermutateListWithRepeatedElements(){
		List<String> listWithRepeatedElems = ImmutableList.of("a", "a", "c");
		List<String> listOfElems = ImmutableList.of("a", "c");
		
		Set<List<String>> permutations = new PermutationFunctor<String>().apply(listWithRepeatedElems);
		int expectedNumOfPermutations = (int)MathUtils.factorial(listWithRepeatedElems.size()) / 2;
		int actualUniqueNumOfPermutations = permutations.stream().map(List::hashCode).collect(toSet()).size();
		
		assertThat(permutations).hasSize(expectedNumOfPermutations)
			.hasSize(actualUniqueNumOfPermutations)
			.allMatch(permutation -> permutation.size() == listWithRepeatedElems.size());
		
		Set<String> actualElemsOfPermutations = permutations.stream().flatMap(l -> l.stream()).collect(toSet());
		assertThat(actualElemsOfPermutations).hasSameSizeAs(listOfElems);
	}

}
