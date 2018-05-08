package com.vrrs.alg.problems.dynamicprog;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TestAnagram {
	
	@Test
	public void willReturnFirstIndex() {
		assertThat(new Anagram().indexOf("zydcbayz", "abc")).isEqualTo(3);
	}

}
