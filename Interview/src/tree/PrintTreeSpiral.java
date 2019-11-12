package tree;

import java.util.Stack;

public class PrintTreeSpiral {

	static void printSpiral(TreeNode root) {
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		s1.push(root);
		while (!s1.empty() || !s2.empty()) {
			while (!s1.empty()) {
				TreeNode temp = s1.pop();
				System.out.print(" " + temp.data + " ");
				if (temp.left != null) {
					s2.push(temp.left);
				}
				if (temp.right != null) {
					s2.push(temp.right);
				}
			}
			while (!s2.empty()) {
				TreeNode temp1 = s2.pop();
				System.out.print(" " + temp1.data + " ");
				if (temp1.right != null) {
					s1.push(temp1.right);
				}
				if (temp1.left != null) {
					s1.push(temp1.left);
				}
			}
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(69);
		root.left = new TreeNode(54);
		root.right = new TreeNode(70);
		root.right.right = new TreeNode(61);
		root.left.right = new TreeNode(11);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(8);

		printSpiral(root);
	}

}
