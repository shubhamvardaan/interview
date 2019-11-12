package tree;

import java.util.Deque;
import java.util.LinkedList;

public class LevelOrderTraversal {
	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
		}
	}

	static void levelOrderTraversal(Node root) {
		if (root == null) {
			System.out.println("root is null");
			return;
		}

		Deque<Node> shubham = new LinkedList<>();
		shubham.addLast(root);
		while (!shubham.isEmpty()) {
			Node temp = shubham.removeFirst();
			System.out.print(temp.data + "  ");
			if (temp.left != null)
				shubham.addLast(temp.left);
			if (temp.right != null)
				shubham.addLast(temp.right);
		}
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		levelOrderTraversal(root);
	}

}
