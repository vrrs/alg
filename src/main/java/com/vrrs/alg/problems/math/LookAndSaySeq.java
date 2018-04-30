package com.vrrs.alg.problems.math;

import java.util.ArrayList;
import java.util.List;

public final class LookAndSaySeq {
	
	public List<Long> get(int n){
		List<Long> seq = new ArrayList<>();
		seq.add(1L); String digits = "1";
		for(int i = 1; i < n; i++) {
			StringBuilder next = new StringBuilder();
			for(int k = 0, count = 0; k < digits.length(); count = 0) {
				Character digit = digits.charAt(k);
				while(k < digits.length() && digits.charAt(k) == digit) {
					count++; k++;
				}
				next.append(count).append(digit);
			}
			digits = next.toString();
			seq.add(Long.parseLong(digits));
		}
		return seq;
	}
}
