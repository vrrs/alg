package org.problems.math;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestLowestCommonMultipleFinders {
	private final LCMFinderSetImpl<Integer> lwcFinder = new LCMFinderSetImpl<Integer>();
	private final LCMFinderGCDImpl gcdBasedLCMFinder = new LCMFinderGCDImpl();
	
	@Test
	public void testSetImpl(){
		int actual = lwcFinder.lowestCommonMultiple(2,3,5);
		assertEquals("Expect 30 as it is the lowest common multiple of 2,3,5.", 30, actual);
	}
	
	@Test
	public void testGCDImpl(){
		int actual = gcdBasedLCMFinder.lowestCommonMultiple(2,3,5);
		assertEquals("Expect 30 as it is the lowest common multiple of 2,3,5.", 30, actual);
	}
}
