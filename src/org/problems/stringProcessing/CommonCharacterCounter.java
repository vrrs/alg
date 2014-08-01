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
  		if(words.length <= 1)  {
    			if (words[0] == null)  throw new NullPointerException("Array must contain at least one element.")
    			return words[0].length();
  		}
  		Set<Character> temp = new HashSet<Character>();
  		Set<Character> intersection = intersectionOf(copyOf(words[0], new HashSet<Character>()), 
  								copyOf(words[1], temp));
  		for(int i = 2; i < words.length; i++)
    			intersection = intersectionOf(intersection, copyOf(words[i], temp));
  		return intersection; 
	}

	private Set<Character> intersectionOf(Set<Character> s1, Set<Character> s2){
  		s1.retainAll(s2);
  		return s1;
	}

	private Set<Character> copyOf(String source, Set<Character> dest){
  		if(dest == null)  throw new AssertionError("Parameter dest must be non-null.");
  		dest.clear();
  		for(Character c : source.toCharArray())
    			dest.add(c);
  		return dest;
	}
}
