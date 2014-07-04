package org.problems;

import java.util.Comparator;

import org.markovLabs.lib.datastructures.cs.NaturalComparator;
import static org.markovLabs.lib.datastructures.cs.NaturalComparator.EQUALS_RELATION;

public class TestUtils {
	
	public static<T> boolean compareArrays(T[] expected, T[] actual) {
		Comparator<T> comparator = new NaturalComparator<T>();
		for(int i = 0; i < expected.length; i++){
			if(comparator.compare(expected[i] , actual[i]) != EQUALS_RELATION)
				return false;
		}
		return true;
	}
}
