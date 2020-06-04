package com.multithreading.examples;

class OrderedBinaryTree {

	class Node {
		int key;
		Node left, right;

		public Node(int item) {
			key = item;
			left = right = null;
		}
	}

	static Node root;

	OrderedBinaryTree() {
		root = null;
	}

	void insert(int key) {
		root = insertRecursively(root, key);
	}

	Node insertRecursively(Node root, int key) {

		if (root == null) {
			root = new Node(key);
			return root;
		}

		if (key < root.key)
			root.left = insertRecursively(root.left, key);
		else if (key > root.key)
			root.right = insertRecursively(root.right, key);

		return root;
	}

	static void printLeaves(Node root) {

		if (root == null)
			return;

		if (root.left == null && root.right == null) {
			System.out.print(root.key + " ");
			return;
		}

		if (root.right != null)
			printLeaves(root.right);

		if (root.left != null)
			printLeaves(root.left);
	}

	public static void main(String[] args) {
		OrderedBinaryTree tree = new OrderedBinaryTree();

		tree.insert(8);
		tree.insert(3);
		tree.insert(10);
		tree.insert(1);
		tree.insert(6);
		tree.insert(14);
		tree.insert(4);
		tree.insert(7);
		tree.insert(13);

		printLeaves(root);
	}
}
