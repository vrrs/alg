package org.problems.datastructures;

import org.markovLabs.lib.datastructures.cs.SingleLinkedList;
import org.markovLabs.lib.datastructures.cs.SingleLinkedList.Node;
/**
 *  Problem: given singly-linked list, Reverse the direction. In other words, after the reversal all pointers should now point backwards. 
 *
 * @author victor regalado
 */
public class SingleLinkedListReverser {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void reverse(SingleLinkedList list){
		Node cur, prev, next;
		prev = list.getHead();
		cur = prev.getNext();
		prev.setNext(null);
		while(cur!=null){
			next = cur.getNext();
			cur.setNext(prev);
			prev = cur;
			cur = next;
		}
	}
}
