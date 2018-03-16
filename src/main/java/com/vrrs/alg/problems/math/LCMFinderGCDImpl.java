package com.vrrs.alg.problems.math;

public class LCMFinderGCDImpl {

	public Integer lowestCommonMultiple(Integer... elems) {
		int n = elems.length;
		int temp = 1;
		for(int i = n-1; i>=0; i--)
			temp = lcm(elems[i],temp);
		return temp;
	}

	private int lcm(Integer num1, Integer num2) {
		return num1*num2 / gcd(num1, num2);
	}

	private int gcd(Integer num1, Integer num2) {
		int temp;
		while( num2 != 0){
			temp = num2;
			num2 = num1 % num2;
			num1 = temp;
		}
		return num1;
	}

}
