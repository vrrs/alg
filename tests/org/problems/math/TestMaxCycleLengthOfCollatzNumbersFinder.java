package org.problems.math;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestMaxCycleLengthOfCollatzNumbersFinder {
	private final MaxCycleLengthOfCollatzNumbersFinder maxCycleFinder = new MaxCycleLengthOfCollatzNumbersFinder();
	
	@Test
	public void test(){	
		assertEquals("Maximum cycle is 20 in [1,10]",20, maxCycleFinder.getMaxCycleLength(1, 10));
	}
	@Test
	public void test1(){	
		assertEquals("Maximum cycle is 125 in [100,200]",125, maxCycleFinder.getMaxCycleLength(100, 200));
	}
	@Test
	public void test2(){	
		assertEquals("Maximum cycle is 89 in [201,210]",89, maxCycleFinder.getMaxCycleLength(201, 210));
	}
	@Test
	public void test3(){	
		assertEquals("Maximum cycle is 174 in [900,1000]",174, maxCycleFinder.getMaxCycleLength(900, 1000));
	}
}
