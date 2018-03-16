package com.vrrs.alg.problems.greedy;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestCompatibleActivitiesSolution {
	@Test
	public void test(){
		int[] startTime =  {4, 2, 5, 8};
		int[] endTimes = {7, 8, 9, 12};
		CompatibleActivities solver = new CompatibleActivities(startTime, endTimes);
		String actual = solver.printOptimalSchedule();
		assertEquals("Must match expectation", "[4-7],[8-12],", actual);
	}
}
