package com.vrrs.alg.problems.dynamicprog;

public class LongestPalindromicSubstring {

	// dyn prog O(n^2)
	public String find(String s) {
		boolean[][] palindromes = new boolean[s.length()][s.length()];
		int maxLb = 0, maxUb = 0;
		for (int size = 1; size <= s.length(); size++) {
			for (int i = 0; i <= s.length() - size; i++) {
				int j = i + size - 1;
				if (isPalindrome(palindromes, s, i, j)) {
					palindromes[i][j] = true;
					if (j - i + 1 > maxUb - maxLb + 1) {
						maxUb = j;
						maxLb = i;
					}
				} else {
					palindromes[i][j] = false;
				}
			}
		}
		return s.substring(maxLb, maxUb + 1);
	}

	public boolean isPalindrome(boolean[][] palindromes, String s, int lb, int ub) {
		int size = ub - lb + 1;
		return (size < 3 || palindromes[lb + 1][ub - 1]) 
				&& s.charAt(lb) == s.charAt(ub);
	}

}
