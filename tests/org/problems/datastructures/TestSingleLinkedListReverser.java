package org.problems.datastructures;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.markovLabs.lib.datastructures.cs.SingleLinkedList;

public class TestSingleLinkedListReverser {
	private final SingleLinkedListReverser reverser = new SingleLinkedListReverser();
	
	@Test
	public void test(){
		SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
		for(int i = 0; i < 10; i++)	list.addItem(i);
		reverser.reverse(list);
		assertEquals("Expect # 9,...,0", "9,8,7,6,5,4,3,2,1,0,",list.toString());
	}
}
