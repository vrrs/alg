package com.vrrs.alg.problems.math;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class TestArithmeticOps {
	
	@Test
	public void willReturnTheSumAsArray() {
		assertThat(new ArithmeticOps().getSum(new int[]{4,5}, new int[] {1,2,3}))
		.containsExactly(1,6,8);
	}
}
