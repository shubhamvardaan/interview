package tree;

import java.util.LinkedList;

public class DistanceBetweenTwoNodeInBinaryTree {

	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
		}
	}

	static boolean fillList(Node root, LinkedList<Node> shubham, int a) {
		if (root == null)
			return false;
		if (root.data == a) {
			shubham.addFirst(root);
			return true;
		}

		if (fillList(root.left, shubham, a) || fillList(root.right, shubham, a)) {
			shubham.addFirst(root);
			return true;
		}
		return false;
	}

	static void printPath(Node root, int a, int b) {
		LinkedList<Node> temp1 = new LinkedList<>();
		LinkedList<Node> temp2 = new LinkedList<>();
		fillList(root, temp1, a);
		fillList(root, temp2, b);
		int count=0;
		

	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.right.left = new Node(8);
		printPath(root, 6, 8);

	}

}
