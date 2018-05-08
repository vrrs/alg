package com.vrrs.alg.problems.dynamicprog;

import java.util.LinkedHashMap;
import java.util.Map;

public class Anagram {
	
	public int indexOf(String text, String pattern) {
		Map<Character, Integer> countPerTextChar = getCountPerChar(text, pattern.length());
		Map<Character, Integer> countPerPatternChar = getCountPerChar(pattern, pattern.length());
		if(countPerPatternChar.equals(countPerTextChar)) return 0;
		for(int i = 1; i < text.length() - pattern.length(); i++) {
			countPerTextChar.remove(text.charAt(i - 1));
			char aChar = text.charAt(i + pattern.length() - 1);
			Integer count = countPerTextChar.get(aChar);
			count = count == null ? 0 : count;
			countPerTextChar.put(aChar, ++count);
			if(countPerPatternChar.equals(countPerTextChar)) return i;	
		}
		return -1;
	}

	private Map<Character, Integer> getCountPerChar(String word, int len) {
		Map<Character, Integer> countPerChar = new LinkedHashMap<>();
		for(int i = 0; i < len; i++) {
			Character c = word.charAt(i);
			Integer count = countPerChar.get(c);
			count = count == null ? 0 : count;
			countPerChar.put(c, ++count);
		}
		return countPerChar;
	}

}
