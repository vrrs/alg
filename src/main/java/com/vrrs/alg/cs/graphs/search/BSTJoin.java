package com.vrrs.alg.cs.graphs.search;

import java.util.Comparator;
import java.util.function.BinaryOperator;

import com.vrrs.alg.cs.graphs.BTNode;

public class BSTJoin <E> implements BinaryOperator<BST<E>> {
	
	private final TreeRotator rotator;
	
	public BSTJoin() {
		this.rotator = new TreeRotator();
	}

	@Override
	public BST<E> apply(BST<E> tree1, BST<E> tree2) {
		Comparator<E> cmp = tree1.getComparator();
		return new BST<E>(cmp, join(cmp, tree1.getRoot(), tree2.getRoot()));
	}
	
	private BTNode<E> join(Comparator<E> cmp, BTNode<E> root1, BTNode<E> root2) {
		if(root1 == null || root2 == null) {
			return root1 == null ? root2 : root1;
		} else {
			insertToTheRoot(cmp, root2, root1.getItem());
			root2.setLeft(join(cmp, root1.getLeft(), root2.getLeft()));
			root2.setRight(join(cmp, root1.getRight(), root2.getRight()));
			return root2;
		}
	}

	private void insertToTheRoot(Comparator<E> cmp, BTNode<E> root, E elem) {
		BTNode<E> parent = findParent(cmp, root, elem), cur = new BTNode<>(elem);
		while(parent != null) {
			if(cmp.compare(cur.getItem(), parent.getItem()) == -1) {
				parent.setLeft(cur);
				cur = rotator.rotateRight(parent);
			} else {
				parent.setRight(cur);
				cur = rotator.rotateLeft(parent);
			}
			parent = cur.getParent();
		}
	}
	
	public BTNode<E> findParent(Comparator<E> cmp, BTNode<E> root, E elem) {
		BTNode<E> prev = null, cur = root;
		while (cur != null) {
			prev = cur;
			if (cmp.compare(cur.getItem(), elem) == 1) {
				cur = cur.getLeft();
			} else {
				cur = cur.getRight();
			}
		}
		return prev;
	}

}
