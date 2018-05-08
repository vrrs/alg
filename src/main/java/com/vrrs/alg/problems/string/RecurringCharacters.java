package com.vrrs.alg.problems.string;

import java.util.LinkedHashMap;
import java.util.Map;

public class RecurringCharacters {
	
	public Character getFirstRecurringCharacters(String word) {
		Map<Character, Integer> countPerChar = new LinkedHashMap<>();
		for(Character c : word.toCharArray()) {
			Integer count = countPerChar.get(c);
			count = count == null ? 0 : count;
			countPerChar.put(c, ++count);
		}
		for(Map.Entry<Character, Integer> entry : countPerChar.entrySet()) {
			if(entry.getValue() > 1) return entry.getKey();
		}
		return null;
	}

}
