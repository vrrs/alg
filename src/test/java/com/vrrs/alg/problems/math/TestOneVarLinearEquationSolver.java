package com.vrrs.alg.problems.math;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class TestOneVarLinearEquationSolver {
	
	@Test
	public void willReturnValueOfX() {
		assertThat(new OneVarLinearEquationSolver().getXValue("x+4=8-x"))
		.isEqualTo(2);
	}

}
