package com.vrrs.alg.problems.dynamicprog;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TestMatrix {
	
	@Test
	public void willReturnLargestSquare() {
		int[][] m = new int[][] {{1,1,0,1,0},{0,1,1,1,0},{1,1,1,1,0},{0,1,1,1,1}};
		assertThat(new Matrix().getLargestSquareOf1(m)).isEqualTo(3);
	}

}
