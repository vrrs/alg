package org.problems.sorting;

import java.util.List;
import java.util.Set;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class DuplicateFinder {
	
	public Integer[] getDuplicates(int[] ar){
		Set<Integer> set = Sets.newHashSet();
		List<Integer> duplicates = Lists.newArrayList();
		for(int elem : ar){
			if(!set.add(elem))
				duplicates.add(elem);
		}
		Integer[] result = new Integer[duplicates.size()];
		duplicates.toArray(result);
		return result;
	}
}
