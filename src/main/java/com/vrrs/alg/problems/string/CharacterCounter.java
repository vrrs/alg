package com.vrrs.alg.problems.string;

import java.util.HashSet;
import java.util.Set;

import com.google.common.collect.Sets;

public class CharacterCounter {

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
	
	public Set<Character> getKMostFrequentCharacters(String word, int k){
		int[] charSet = new int[256];
		for(Character c : word.toCharArray()) {
			charSet[c] += 1;
		}
		int total = 0;
		for(Character c : word.toCharArray()) {
			int tmp = charSet[c];
			charSet[c] = total;
			total += tmp;
		}
		int[] countSet = new int[256];
		for(Character c : word.toCharArray()) {
			countSet[charSet[c]] = c;
			charSet[c] += 1;
		}
		Set<Character> kMostFrequentChars = new HashSet<>();
		for(int i = 255, j = 0; i >= 0 && j < k; i--){
			if(countSet[i] != 0 && !kMostFrequentChars.contains((char)countSet[i])) {
				kMostFrequentChars.add((char)countSet[i]);
				j++;
			}
		}
		return kMostFrequentChars;
	}
}
