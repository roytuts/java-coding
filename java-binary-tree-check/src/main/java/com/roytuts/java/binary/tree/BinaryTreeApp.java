package com.roytuts.java.binary.tree;

public class BinaryTreeApp {
	private Node root;
	private Node prev;

	public static void main(String[] args) {
		BinaryTreeApp binaryTree = new BinaryTreeApp();
		binaryTree.root = binaryTree.new Node(5);
		binaryTree.root.left = binaryTree.new Node(3);
		binaryTree.root.right = binaryTree.new Node(6);
		binaryTree.root.left.left = binaryTree.new Node(1);
		//binaryTree.root.left.right = binaryTree.new Node(2); //not a binary search tree
		binaryTree.root.left.right = binaryTree.new Node(4); //binary search tree
		System.out.println(binaryTree.isBST(binaryTree.root));
	}

	private boolean isBST(Node node) {		
		if (node != null) {
			if (!isBST(node.left)) {
				return false;
			}
			
			if (prev != null && node.data <= prev.data) {
				return false;
			}
			
			prev = node;
			
			return isBST(node.right);
		}
		
		return true;
	}

	private class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}
}
