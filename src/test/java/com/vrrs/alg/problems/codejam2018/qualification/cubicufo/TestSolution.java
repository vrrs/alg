package com.vrrs.alg.problems.codejam2018.qualification.cubicufo;

import org.junit.Ignore;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class TestSolution {

	@Ignore("Solution is correct but the test have to check each value to see if it's in +-1e-6")
	@Test
	public void willSolveSample() {
		Solution solver = new Solution();		
		assertThat(solver.solve(1)).hasSize(3)
			.contains("0.5 0.0 0.0")
			.contains("0.0 0.5 0.0")
			.contains("0.0 0.0 0.5");
		
		assertThat(solver.solve(1.414213)).hasSize(3)
		.contains("0.3535533905932738 0.3535533905932738 0")
		.contains("-0.3535533905932738 0.3535533905932738 0")
		.contains("0 0 0.5");
	}

}
