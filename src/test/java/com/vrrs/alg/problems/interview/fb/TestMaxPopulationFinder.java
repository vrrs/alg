package com.vrrs.alg.problems.interview.fb;

import org.junit.Test;
import com.google.common.collect.ImmutableList;
import com.vrrs.alg.cs.graphs.Interval;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

public class TestMaxPopulationFinder {
	
	@Test
	public void willReturnMaxPopulation() {
		List<Interval> peopleLifeSpans = ImmutableList.of(new Interval(60, 90)
				, new Interval(70, 100), new Interval(70, 80));
		assertThat(new MaxPopulationFinder().find(peopleLifeSpans)).isEqualTo(70);
	}

}
