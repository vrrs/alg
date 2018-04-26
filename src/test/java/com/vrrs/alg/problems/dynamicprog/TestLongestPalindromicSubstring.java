package com.vrrs.alg.problems.dynamicprog;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

public class TestLongestPalindromicSubstring {
	
	@Test
	public void willFindLongestPalindromicSubstring() {
		assertThat(new LongestPalindromicSubstring().find("forgeeksskeegfor"))
		.isEqualTo("geeksskeeg");
	}
}
