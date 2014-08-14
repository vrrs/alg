package org.problems.combinatorial.pairsOfTargetSum;

import java.util.Set;
import java.util.HashSet;
/**
  * Problem: Given a list elems, print all pairs whose sum is equal to the given target total.
  *  If the input array contains duplicates, it will throw IllegalArgumentException.
  *@Author victor regalado
**/
final class PairsOfTargetSumWithUniqueElements implements PairsOfTargetSum{

  public void printPairs(int ar[], int target){
    Set<Integer> elems = verifyNoDuplication(ar);
    for(Integer elem1 : ar){
        int elem2 = target - elem1;
        if(elem1 == elem2 || !elems.contains(elem2))  continue;
        System.out.print("("+elem1+","+elem2+"),");
        elems.remove(elem1);
        elems.remove(elem2);
    }
  }

  private Set<Integer> verifyNoDuplication(int[] ar){
    Set<Integer> elems = new HashSet<>();
    for(Integer elem : ar)  {
      if(!elems.contains(elem))
        elems.add(elem);
      else
        throw new IllegalArgumentException("Input array contains duplicate elements.");
    }
    return elems;
  }
}
