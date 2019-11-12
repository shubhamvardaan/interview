package tree;

import java.util.Stack;

public class MergeTwoBST {
	static class node {
		int data;
		node left, right;

		public node(int data) {
			this.data = data;
		}

		public void insert(int x) {
			if (x < data) {
				if (left == null) {
					left = new node(x);
				} else {
					left.insert(x);
				}
			} else if (data < x) {
				if (right == null)
					right = new node(x);
				else
					right.insert(x);
			}
		}
	}

	static void inOrderBST(node root) {
		if (root == null)
			return;
		inOrderBST(root.left);
		System.out.println(root.data + "  ");
		inOrderBST(root.right);
	}

	static void merge(node root1, node root2) {
		Stack<node> stack1 = new Stack<>();
		Stack<node> stack2 = new Stack<>();
		node temp1 = root1;
		node temp2 = root2;
		if (root1 == null) {
			inOrderBST(root2);
			return;
		}
		if (root2 == null) {
			inOrderBST(root1);
			return;
		}

		while (temp1 != null || temp2 != null || !stack1.isEmpty() || !stack2.isEmpty()) {
			if (temp1 != null || temp2 != null) {
				if (temp1 != null) {
					stack1.push(temp1);
					temp1 = temp1.left;
				}
				if (temp2 != null) {
					stack2.push(temp2);
					temp2 = temp2.left;
				}
			} else {
				if (stack1.isEmpty()) {
					while (!stack2.isEmpty()) {
						temp2 = stack2.pop();
						temp2.left = null;
						inOrderBST(temp2);
					}
					return;
				}
				if (stack2.isEmpty()) {
					while (!stack1.isEmpty()) {
						temp1 = stack1.pop();
						temp1.left = null;
						inOrderBST(temp1);
					}
					return;
				}

				temp1 = stack1.pop();
				temp2 = stack2.pop();
				if (temp1.data < temp2.data) {
					System.out.println(temp1.data + " ");
					temp1 = temp1.right;
					stack2.push(temp2);
					temp2 = null;
				} else {
					System.out.println(temp2.data + " ");
					temp2 = temp2.right;
					stack1.push(temp1);
					temp1 = null;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] shubham1 = { 12, 3, 4, 1, 7 };
		int[] shubham2 = { 1, 76, 11, 76, 6, 5, 82 };
		node root1 = new node(shubham1[0]);
		node root2 = new node(shubham2[0]);
		for (int i = 0; i < shubham1.length; i++)
			root1.insert(shubham1[i]);
		for (int i = 0; i < shubham2.length; i++)
			root2.insert(shubham2[i]);
		merge(root1, root2);
	}
}
