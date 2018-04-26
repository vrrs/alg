package com.vrrs.alg.problems.graph;

import org.junit.Test;

import com.vrrs.alg.cs.graphs.BTNode;
import com.vrrs.alg.cs.graphs.search.BST;

import static org.assertj.core.api.Assertions.*;

public class TestBTMaxWidthFinder {
	
	@Test
	public void willComputeMaxWidthOfBT(){
		assertThat(new BTMaxWidthFinder().getMaxWidth(getRootOfIntTree()))
			.isEqualTo(4);
	}
	
	private BTNode<Integer> getRootOfIntTree(){
		BST<Integer> tree = new BST<>(Integer::compare);
        /* Creates following BST
        50
     /     \
    30      70
   /  \    /  \
  20   40  60   80 */
		tree.add(50);
		tree.add(30);
		tree.add(20);
		tree.add(40);
		tree.add(70);
		tree.add(60);
		tree.add(80);
		return tree.getRoot();
	}

}
