package tree;

import tree.LevelWithMaxSum.Node;

public class HasPathSum {
	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
		}
	}

	static boolean hasPathSum(Node root, int sum) {
		if (root == null)
			return sum == 0;
		else {
			int remainingSum = sum - root.data;
			if ((root.left != null && root.right != null) || (root.left == null && root.right == null))
				return hasPathSum(root.left, remainingSum) || hasPathSum(root.right, remainingSum);
			else if (root.left != null)
				return hasPathSum(root.left, remainingSum);
			else
				return hasPathSum(root.right, remainingSum);
		}
	}

	public static void main(String[] args) {
		Node root = new Node(12);
		root.left = new Node(1);
		root.right = new Node(4);
		root.left.left = new Node(6);
		root.left.right = new Node(8);
		root.right.right = new Node(30);
		System.out.println(hasPathSum(root,1019));
	}
}
