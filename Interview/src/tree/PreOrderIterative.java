package tree;

import java.util.Stack;

public class PreOrderIterative {
	static class node {
		int data;
		node left, right;

		public node(int x) {
			data = x;
		}
	}

	public void preOrderIterative(node root) {
		if (root == null)
			return;
		Stack<node> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			node temp = stack.pop();
			System.out.println(temp.data + "  ");
			if (temp.right != null)
				stack.push(temp.right);
			if (temp.left != null)
				stack.push(temp.left);
		}
	}

	public static void main(String[] args) {
		node root = new node(3);
		root.left = new node(10);
		root.right = new node(44);
		root.right.left = new node(65);
		root.left.left = new node(231);
		new PreOrderIterative().preOrderIterative(root);
	}
}
