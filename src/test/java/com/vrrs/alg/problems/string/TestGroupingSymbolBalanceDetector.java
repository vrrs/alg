package com.vrrs.alg.problems.string;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.vrrs.alg.problems.string.GroupingSymbolBalanceDetector;

public class TestGroupingSymbolBalanceDetector {
	private final GroupingSymbolBalanceDetector detector = new GroupingSymbolBalanceDetector();
	
	@Test 
	public void test(){
		assertTrue("Expect well formed expression.", detector.isBalance("(v+x*2)+[f+9]"));
		assertFalse("Expect a malformed expression with missing ).", detector.isBalance("v+x(9+[8+9]"));
		assertFalse("Expect a malformed expression with missing ].", detector.isBalance("v+x(9+[8+9]]"));
		assertFalse("Expect a malformed expression with reverse order of symbols.", detector.isBalance("v+x)9+[8+9]("));
	}
}
