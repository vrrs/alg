package org.problems.stringProcessing;

import java.util.Set;

import com.google.common.collect.Sets;

/**
 * 	Problem: Given String[], find the # of common characters. 
 * This problem can be generalized as follows: Given a set of sequences, find the # of common elements.  
 * @author victor regalado
 */
public class CommonCharacterCounter {
	
	public int getTotalOfCommonCharacters(String[] words){
		Set<Character> intersection = Sets.newHashSet();
		Set<Character> wordSet = Sets.newHashSet();
		insertFirstWord(words[0], intersection);
		for(int i = 1; i < words.length; i++){
			String word = words[i];
			wordSet.clear();
			for(Character c : word.toCharArray())	wordSet.add(c);
			intersection.retainAll(wordSet);
		}
		return intersection.size();
	}

	private void insertFirstWord(String firstWord, Set<Character> intersection) {
		for(Character c : firstWord.toCharArray())
			intersection.add(c);
	}
}
