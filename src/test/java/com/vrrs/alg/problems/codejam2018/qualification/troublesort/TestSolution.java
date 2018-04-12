package com.vrrs.alg.problems.codejam2018.qualification.troublesort;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TestSolution {
	
	@Test
	public void willSolveSample() {
		Solution solver = new Solution();
		assertThat(solver.solve(list(5,6,8,4,3))).isEqualTo("OK");
		assertThat(solver.solve(list(8,9,7))).isEqualTo("1");
	}
	
	private List<Integer> list(Integer ... elems){
		return Arrays.asList(elems);
	}
	

}
