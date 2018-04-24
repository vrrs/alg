package com.vrrs.alg.cs.graphs.search;

import com.vrrs.alg.cs.graphs.BTNode;

public final class TreeRotator {
	
	//x = node.left;node.left = x.right; x.right = node;
	public <E> BTNode<E> rotateRight(BTNode<E> node){
		BTNode<E> nodeToRotate = node.getLeft();
		node.setLeft(nodeToRotate.getRight());
		if(nodeToRotate.getRight() != null) {
			nodeToRotate.getRight().setParent(node);
		}
		nodeToRotate.setRight(node);
		BTNode<E> nodeParent = node.getParent();
		nodeToRotate.setParent(nodeParent);
		if(nodeParent != null) {
			if(nodeParent.getLeft().equals(node)) {
				nodeParent.setLeft(nodeToRotate);
			} else {
				nodeParent.setRight(nodeToRotate);
			}
		}
		node.setParent(nodeToRotate);
		return nodeToRotate;
	}
	
	public <E> BTNode<E> rotateLeft(BTNode<E> node){
		BTNode<E> nodeToRotate = node.getRight();
		node.setRight(nodeToRotate.getLeft());
		nodeToRotate.setLeft(node);
		BTNode<E> nodeParent = node.getParent();
		nodeToRotate.setParent(nodeParent);
		if(nodeParent != null) {
			if(nodeParent.getLeft().equals(node)) {
				nodeParent.setLeft(nodeToRotate);
			} else {
				nodeParent.setRight(nodeToRotate);
			}
		}
		node.setParent(nodeToRotate);
		return nodeToRotate;
	}

}
