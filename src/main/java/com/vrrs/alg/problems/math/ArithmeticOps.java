package com.vrrs.alg.problems.math;

public class ArithmeticOps {
	
	public int[] getSum(int[] a, int[] b) {
		if(b.length > a.length) return getSum(b, a);
		StringBuilder builder = new StringBuilder();
		int carry = 0;
		for(int i = b.length - 1, j = a.length - 1; j >= 0;) {
			int sum = a[j--] + carry;
			if(i >= 0) sum += b[i--];
			carry = sum / 10;
			builder.insert(0, sum % 10);
		}
		if(carry > 0) {
			builder.insert(0, carry);
		}
		String numAsStr = builder.toString();
		int[] num = new int[numAsStr.length()];
		for(int i = 0; i < numAsStr.length(); i++) 
			num[i] = Integer.parseInt(numAsStr.substring(i, i + 1));
		return num;
	}

}
