package org.problems.sorting;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestMaxPMeanOfArrayRotationsFinder {
	private final MaxPMeanOfArrayRotationsFinder finder = new MaxPMeanOfArrayRotationsFinder();
	
	@Test
	public void test(){
		int[] input = {20,30,10};
		int actual = finder.MaxPMeanOfArrayRotations(input);
		int expectation = 140;
		assertEquals("Expect 140 when input is 20,30,10.", expectation, actual);
	}
}
