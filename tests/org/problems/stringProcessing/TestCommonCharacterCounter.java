package org.problems.stringProcessing;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TestCommonCharacterCounter {
	
	@Test
	public void test(){
		String[] input = {"aaaabbc", "hdjnffb", "ccgdaab"};
		CommonCharacterCounter counter = new CommonCharacterCounter();
		final long expected = 1;
		final long actual = counter.getTotalOfCommonCharacters(input); 
		assertEquals("Expect 1 character in common, b, from aaaabbc, hdjnffb, ccgdaab.", expected, actual);
	}
}
