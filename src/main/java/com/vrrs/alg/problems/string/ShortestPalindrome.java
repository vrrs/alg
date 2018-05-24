package com.vrrs.alg.problems.string;

public class ShortestPalindrome {

	public String getShortestPalindrome(String s) {
		for (int n = s.length(); n > 0; n--) {
			if (isPalindrome(n, s)) {
				String str = new StringBuilder(s.substring(n, s.length())).reverse().toString();
				return str + s;
			}
		}
		return "";
	}

	private boolean isPalindrome(int size, String s) {
		for (int i = 0, j = size - 1; i < j; i++) {
			if (s.charAt(i) != s.charAt(j--))
				return false;
		}
		return true;
	}

}
