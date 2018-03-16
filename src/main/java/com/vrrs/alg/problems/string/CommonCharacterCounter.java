package com.vrrs.alg.problems.string;

import java.util.Set;

import com.google.common.collect.Sets;

/**
 * Problem: Given String[], find the # of common characters.
 * 
 * @author victor regalado
 */
public class CommonCharacterCounter {

	public int getTotalOfCommonCharacters(String[] words) {
		Set<Character> chars = newSetOfChars(words[0]);
		for (int i = 1; i < words.length && !chars.isEmpty(); i++) {
			chars.retainAll(newSetOfChars(words[i]));
		}
		return chars.size();
	}

	private Set<Character> newSetOfChars(String word) {
		Set<Character> chars = Sets.newLinkedHashSet();
		for(Character aChar : word.toCharArray()) {
			chars.add(aChar);
		}
		return chars;
	}
}
