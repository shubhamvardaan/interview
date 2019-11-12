package tree;

import tree.HasPathSum.Node;

public class PrintAllAncestors {
	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
		}
	}

	static boolean printAllAncestors(Node root, int target) {
		if (root == null)
			return false;
		if (root.data == target) {
			return true;
		}
		if (printAllAncestors(root.left, target) || printAllAncestors(root.right, target)) {
			System.out.println(root.data + " ");
			return true;
		}

		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(12);
		root.left = new Node(1);
		root.right = new Node(4);
		root.left.left = new Node(6);
		root.left.right = new Node(8);
		root.right.right = new Node(30);
		printAllAncestors(root, 30);
	}

}
