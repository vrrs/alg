package com.vrrs.alg.problems.codejam2018.qualification.saveuniverse;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class TestSolution {
	
	@Test
	public void willSolveSample() {
		Solution solver = new Solution();		
		assertThat(solver.solve(1, "CS")).isEqualTo("1");
		assertThat(solver.solve(2, "CS")).isEqualTo("0");
		assertThat(solver.solve(1, "SS")).isEqualTo("IMPOSSIBLE");
		assertThat(solver.solve(6, "SCCSSC")).isEqualTo("2");
		assertThat(solver.solve(2, "CC")).isEqualTo("0");
		assertThat(solver.solve(3, "CSCSS")).isEqualTo("5");
	}

}
