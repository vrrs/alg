package org.problems.combinatorial.pairsOfTargetSum;

import java.util.Map;
import java.util.HashMap;
/**
	* Problem: Given a list of elems, repeated or not, print all pairs whose sum is equal to the given target total.
	*@Author victor regalado
**/

final class PairsOfTargetSumWithDuplicates implements PairsOfTargetSum{

  public void printPairs(int ar[], int target){
    Map<Integer, Integer> hist = histogramOf(ar);
    for(Integer elem1 : hist.keySet()){
	int count1 = hist.get(elem1);
	if(count1 <= 0 )	continue;
	int elem2 = target - elem1;
	int count = Math.min(count1, hist.get(elem2));
	count = elem2 == elem1	?	count / 2	:	count;
	for(int i = 0; i < count; i++)
		System.out.print("("+elem1+","+elem2+"),");
	hist.put(elem2, 0);
	hist.put(elem1, 0);
    }
 }


  private Map<Integer, Integer> histogramOf(int[] ar){
    Map<Integer, Integer> hist = new HashMap<>(3*ar.length/4);
    for(Integer elem : ar){
      Integer count = hist.get(elem);
      if(count == null)	count = 0;
      hist.put(elem, ++count);
    }
    return hist;
  }

}
