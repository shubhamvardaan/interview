package tree;

import tree.SortedLinkedListToBST.Node;

public class TreePrune {
	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
		}
	}

	static void inOrder(Node root) {
		if (root == null)
			return;
		inOrder(root.left);
		System.out.print(root.data + "  ");
		inOrder(root.right);
	}

	static Node pruneBST(Node root, int a, int b) {
		if (root == null)
			return root;
		root.left = pruneBST(root.left, a, b);
		root.right = pruneBST(root.right, a, b);
		if (root.data < a) {
			Node left = root.right;
			root = null;
			return left;
		}
		if (b < root.data) {
			Node right = root.left;
			root = null;
			return right;
		}
		return root;
	}

	public static void main(String[] args) {
		Node root = new Node(12);
		root.left = new Node(8);
		root.left.left = new Node(3);
		root.left.right = new Node(10);
		root.right = new Node(24);
		root.right.left = new Node(20);
		root.right.right = new Node(34);
		root = pruneBST(root, 20, 34);
		inOrder(root);
	}
}
