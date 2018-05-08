package com.vrrs.alg.problems.math;

import org.junit.Test;
import com.google.common.collect.ImmutableList;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

public class TestLookAndSaySeq {
	
	@Test
	public void willGenerateLookAndSaySeq() {
		List<Long> seq = ImmutableList.of(1L, 11L, 21L, 1211L, 111221L, 312211L, 13112221L, 1113213211L);
		assertThat(new LookAndSaySeq().get(8)).containsAll(seq);
	}

}
