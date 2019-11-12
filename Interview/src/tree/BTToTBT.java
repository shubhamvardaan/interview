package tree;

import java.util.LinkedList;

public class BTToTBT {
	static class Node {
		int data;
		Node left, right;
		boolean isThreaded;

		Node(int data) {
			this.data = data;
		}
	}

	static Node leftMostNode(Node root) {
		Node current = root;
		while (current != null && current.left != null)
			current = current.left;
		return current;
	}

	static void populateList(Node root, LinkedList<Node> list) {
		if (root == null)
			return;
		populateList(root.left, list);
		list.addLast(root);
		populateList(root.right, list);
	}

	static void createThreadedBinaryTree(Node root, LinkedList<Node> list) {
		if (root == null)
			return;
		if (root.left != null)
			createThreadedBinaryTree(root.left, list);
		list.pollFirst();
		if (root.right != null)
			createThreadedBinaryTree(root.right, list);
		else {
			root.right = list.peek();
			root.isThreaded = true;
		}

	}

	static void createThreadedBT(Node root) {
		if (root == null)
			return;
		LinkedList<Node> list = new LinkedList<>();
		populateList(root, list);
		createThreadedBinaryTree(root, list);
	}

	static void inOrder(Node root) {
		if (root == null)
			return;
		Node temp = leftMostNode(root);
		while (temp != null) {
			System.out.print(temp.data + "  ");
			if (temp.isThreaded)
				temp = temp.right;
			else
				temp = leftMostNode(temp.right);
		}
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		createThreadedBT(root);
		System.out.println("Inorder traversal of created threaded tree");
		inOrder(root);
	}
}
