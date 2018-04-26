package com.vrrs.alg.cs.graphs.search;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class TestTreeMapper {

	@Test
	public void willComputeTreeHeight() {
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

		assertThat(new TreeMapper().getHeight(tree.getRoot())).isEqualTo(3);
	}

}
