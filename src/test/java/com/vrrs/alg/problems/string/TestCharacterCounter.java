package com.vrrs.alg.problems.string;

import org.junit.Test;

import com.vrrs.alg.problems.string.CharacterCounter;

import static org.junit.Assert.assertEquals;
import java.util.Set;
import static org.assertj.core.api.Assertions.*;


public class TestCharacterCounter {
	
	@Test
	public void willReturnNumOfCommonChars(){
		String[] input = {"aaaabbc", "hdjnffb", "ccgdaab"};
		CharacterCounter counter = new CharacterCounter();
		final long expected = 1;
		final long actual = counter.getTotalOfCommonCharacters(input); 
		assertEquals("Expect 1 character in common, b, from aaaabbc, hdjnffb, ccgdaab.", expected, actual);
	}
	
	@Test
	public void willReturnMostFrequentCharacters() {
		Set<Character> chars = new CharacterCounter()
				.getKMostFrequentCharacters("ccgdaab", 3);
		assertThat(chars).containsExactly('a', 'c', 'b');
	}
}
