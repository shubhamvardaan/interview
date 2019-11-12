package tree;

import java.util.ArrayList;
import java.util.List;

public class LeftViewBinaryTree {
	private static class shubham {
		int maxLevel = -1;
	}

	static void leftView(TreeNode root, List<Integer> list, int level, shubham s) {
		if (root == null)
			return;
		if (s.maxLevel < level) {
			list.add(root.data);
			s.maxLevel = level;
		}
		leftView(root.left, list, level + 1, s);
		leftView(root.right, list, level + 1, s);
	}

	static List<Integer> leftViewtree(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		int level = 0;
		shubham s = new shubham();
		leftView(root, list, level, s);
		return list;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(69);
		root.left = new TreeNode(54);
		root.right = new TreeNode(70);
		root.right.right = new TreeNode(61);
		root.left.right = new TreeNode(11);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(8);

		System.out.println(leftViewtree(root));
	}

}
