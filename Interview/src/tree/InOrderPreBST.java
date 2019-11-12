package tree;

import tree.InOrderSuccessor.Node;

public class InOrderPreBST {
	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
		}
	}

	static Node rightMostNode(Node root) {
		Node current = root;
		while (current != null && current.right != null)
			current = current.right;
		return current;
	}

	static Node bstSearch(Node root, int key) {
		if (root == null)
			return null;
		if (root.data == key)
			return root;
		else if (key < root.data)
			return bstSearch(root.left, key);
		else
			return bstSearch(root.right, key);
	}

	static void inOrderPredBST(Node root, int key) {
		Node temp = bstSearch(root, key);
		Node pred = null;
		Node current = root;
		if (temp.left != null) {
			System.out.println(rightMostNode(temp.left).data);
			return;
		}
		while (current.data != key) {
			if (current.data > key)
				current = current.left;
			else if (current.data < key) {
				pred = current;
				current = current.right;
			}
		}
		System.out.println(pred.data);

	}

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(5);
		root.left.left = new Node(3);
		root.left.right = new Node(7);
		root.right = new Node(23);
		root.right.left = new Node(19);
		root.right.right = new Node(26);
		inOrderPredBST(root, 5);
	}
}
