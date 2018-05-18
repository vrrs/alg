package com.vrrs.alg.problems.dynamicprog;

import java.util.List;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.google.common.collect.Lists;

public class TestKSubList {

	//@Test
	public void willFindSumEqualTo10() {
		List<Integer> kList = new KSubList(3)
				.getSubListWithSum(Lists.newArrayList(1,2,3,5,10,-4), 11);
		assertThat(kList).containsExactly(5, 10, -4);
	}
	
 	  public String shortestPalindrome(String s) {
	        int n = s.length();
	        int initCenter = n / 2;
	        int minRemain = Integer.MAX_VALUE;
	        for(int center = initCenter; center >= 0; center--){
	            int remain = Math.min(getRemain(s, false, center), getRemain(s, true, center));
	            if(minRemain > remain) minRemain = remain;
	        }
	        StringBuilder builder = new StringBuilder(s);
	        for(int i = minRemain; i >= 1; i--){
	            builder.insert(0, s.charAt(n - i));
	        }
	        return builder.toString();
	    }

	private int getRemain(String s, boolean isEven, int center) {
		  int n = s.length();
		int size = 1;
           boolean foundPalindrome = false;
		for(;size <= center; size++){
		    int left = center - size;
		    int right = size == 1 && isEven ? center : center + size;
		    if(s.charAt(left) != s.charAt(right)) break; else foundPalindrome = true;
		}
		return (!foundPalindrome) ?  n - 1 : n - (center + size);
	}
	  
		@Test
		public void test() {
			assertThat(this.shortestPalindrome("abbacd")).isEqualTo("dcabbacd");
		}
}
