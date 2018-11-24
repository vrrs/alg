
package com.vrrs.alg.problems.combinatorics;

import java.util.function.Supplier;
import java.util.Set;
import java.util.HashSet;
import java.util.BitSet;
import java.util.List;

public final class PowerSetSupplier implements Supplier<Set<Set<Integer>>> {

  private final List<Integer> elems;

  public PowerSetSupplier(List<Integer> elems) {
    this.elems = elems;
  }

  @Override
  public Set<Set<Integer>> get() {
    int n = elems.size();
    Set<Set<Integer>> sets = new HashSet<>();
    int totalNumOfSets = (int)Math.pow(2, n);
    for (int i = 0; i < totalNumOfSets; i++) {
      BitSet bitset = BitSet.valueOf(new long[]{i});
      Set<Integer> set = new HashSet<>();
      for(int j = 0; j < n; j++) {
        if(bitset.get(j)) {
          set.add(elems.get(j));
        }
      }
      sets.add(set);
    }
    return sets;
  }

}
