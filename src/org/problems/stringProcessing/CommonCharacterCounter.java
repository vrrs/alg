package org.problems.stringProcessing;
import java.util.HashSet;
import java.util.Set;

/**
 * 	Problem: Given String[], find the # of common characters. 
 * This problem can be generalized as follows: Given a set of sequences, find the # of common elements.  
 * @author victor regalado
 */
public class CommonCharacterCounter {
	
	public int getTotalOfCommonCharacters(String[] words){
		if(words.length == 1)	return words[0].length();
		Set<Character> intersection = intersectionOf(words[0].toCharArray(), words[1].toCharArray());
		for(int i = 2; i < words.length; i++){
			String word = words[i];
			intersection = intersectionOf(intersection ,word.toCharArray());
		}
		return intersection.size();
	}

	private Set<Character> intersectionOf(char[] firstWordChars, char[] secondWordChars) {
		Set<Character> intersection = new HashSet<Character>();
		for(Character c : firstWordChars)	intersection.add(c);
		return intersectionOf(intersection, secondWordChars);
	}

	private Set<Character> intersectionOf(Set<Character> intersection, char[] secondWordChars) {
		char mark = getMark(secondWordChars);
		for(int i = 0; i <  secondWordChars.length; i++)
			if(!intersection.contains(secondWordChars[i]))
				secondWordChars[i] = mark;
		intersection.clear();
		for(char c : secondWordChars)
			if(c != mark)
				intersection.add(c);
		return intersection;
	}

	private char getMark(char[] chars){
		char max = chars[0];
		for(int i = 1; i< chars.length; i++)
			if(max < chars[i])
				max = chars[i];
		return (char) ((int) max + 1);
	}
}
