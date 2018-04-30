package com.vrrs.alg.problems.interview.fb;

import org.junit.Test;
import com.google.common.collect.ImmutableList;
import static org.assertj.core.api.Assertions.*;

public class TestSpiralMatrix {
	
	@Test
	public void willReturnSpiralList() {
        int spiral[][] = { {1,  2,  3}, {4,  5,  6}, {7,  8,  9}};
        assertThat(new SpiralMatrix().getFlattenSpiral(spiral))
        .containsAll(ImmutableList.of(1,2,3,6,9,8,7,4,5));
	}
	
	@Test
	public void willReturnSpiral() {
        int spiral[][] = { {1,  2,  3}, {8, 9, 4}, {7, 6, 5}};
        assertThat(new SpiralMatrix().getSpiral(3))
        .isEqualTo(spiral);
	}

}
