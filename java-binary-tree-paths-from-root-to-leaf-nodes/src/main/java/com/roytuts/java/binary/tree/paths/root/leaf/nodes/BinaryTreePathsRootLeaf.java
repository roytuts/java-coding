package com.roytuts.java.binary.tree.paths.root.leaf.nodes;

public class BinaryTreePathsRootLeaf {

	public static void main(String[] args) {
		Node<Integer> rootNode = new Node<>(45);
		Node<Integer> node20 = new Node<>(25);
		Node<Integer> node10 = new Node<>(15);
		Node<Integer> node30 = new Node<>(30);
		Node<Integer> node60 = new Node<>(60);
		Node<Integer> node50 = new Node<>(50);
		Node<Integer> node70 = new Node<>(75);
		Node<Integer> node5 = new Node<>(5);
		Node<Integer> node55 = new Node<>(55);

		rootNode.left = node20;
		rootNode.right = node60;

		node20.left = node10;
		node20.right = node30;

		node60.left = node50;
		node60.right = node70;
		node10.left = node5;
		node50.right = node55;

		printPathRootToLeaf(rootNode, new Integer[10], 0);
	}

	public static void printPathRootToLeaf(Node<Integer> node, Integer[] path, int len) {
		if (node == null) {
			return;
		}

		path[len] = node.data;
		
		len++;

		if (node.left == null && node.right == null) {
			printArrayElements(path, len);
			return;
		}

		printPathRootToLeaf(node.left, path, len);
		printPathRootToLeaf(node.right, path, len);
	}

	private static void printArrayElements(Integer[] path, int len) {
		String sep = "";
		for (int i = 0; i < len; i++) {
			System.out.print(sep + path[i]);
			sep = " -> ";
		}
		System.out.println();
	}

	static class Node<E> {

		E data;
		Node<E> left;
		Node<E> right;

		public Node(E data) {
			this.data = data;
		}

	}
}
