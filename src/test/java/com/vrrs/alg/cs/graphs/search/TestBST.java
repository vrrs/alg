package com.vrrs.alg.cs.graphs.search;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class TestBST {
	
	@Test
	public void willDeleteNodes() {
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
 
        System.out.println("Inorder traversal:" + tree.getInorderVisits());
        tree.remove(20);
        System.out.println("Inorder traversal:" + tree.getInorderVisits());
        assertThat(tree.find(20).isEmpty()).isTrue();
        tree.remove(30);
        System.out.println("Inorder traversal:" + tree.getInorderVisits());
        assertThat(tree.find(30).isEmpty()).isTrue();
        tree.remove(50);
        System.out.println("Inorder traversal:" + tree.getInorderVisits());
        assertThat(tree.find(50).isEmpty()).isTrue();
	}
	
	@Test
	public void willVisitInPreorderAndPostorder() {
		BST<Integer> tree = new BST<>(Integer::compare);
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);
        assertThat(tree.getPreorderVisits()).containsExactly(1,2,3,4,5);
        assertThat(tree.getPostorderVisits()).containsExactly(5,4,3,2,1);
	}

}
