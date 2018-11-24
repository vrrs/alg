
package com.vrrs.alg.problems.sorting;

import java.util.List;
import java.util.ArrayList;

public class ListSorter {

  public List<Integer> sortKList(List<List<Integer>> lists){
    return sortKList(0, lists.size() - 1, lists);
  }

  private List<Integer> sortKList(int lb, int ub, List<List<Integer>> lists) {
    if (lb >= ub) {
      return lists.get(lb);
    }
    int mid = (lb + ub) / 2;
    List<Integer> left = sortKList(lb, mid, lists);
    List<Integer> right = sortKList(mid + 1, ub, lists);
    return merge(left, right);
  }

  private List<Integer> merge(List<Integer> left, List<Integer> right) {
    List<Integer> result = new ArrayList<>();
    int i = 0, j = 0;
    for(;i < left.size() && j < right.size();){
      if(left.get(i) <= right.get(j)){
        result.add(left.get(i++));
      } else {
        result.add(right.get(j++));
      }
    }
    for(int k = i; k < left.size(); k++)  result.add(left.get(k));
    for(int k = j; k < right.size(); k++)  result.add(right.get(k));
    return result;
  }

}
