/**
*   This class find the max of a list that has an increasing sequence of ints followed by a decreasing sequence.
*   @author victor regalado
*/
public final class ArrayMaxFinder {

  public int solve(int[] ar){
    int ub = ar.length - 1, lb = 0, cur, prev, next, i;
    while(lb < ub){
      if(ub - lb + 1 <= 2)  return Math.max(ar[lb], ar[ub]);
      i = (ub + lb) / 2;
      cur = ar[i]; prev = ar[i - 1]; next = ar[i + 1];
      if((next > cur) && (cur > prev))  lb = i + 1;  // go to the right
        else  if((next < cur) && (cur < prev))  ub = i - 1;  // go to the left
                else  return max3(prev, cur, next);
    }
    return ar[lb];
  }

  private int max3(int a, int b, int c){
    int max = Math.max(a, b);
    return Math.max(c,max);
  }

}
