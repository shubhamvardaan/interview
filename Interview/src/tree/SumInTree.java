package tree;

import java.util.HashSet;
import java.util.Iterator;

public class SumInTree {
	static void inOrder(TreeNode root, HashSet<Integer> b) {
		if (root == null)
			return;
		inOrder(root.left, b);
		b.add(root.data);
		inOrder(root.right, b);
	}

	static boolean isSumPresent(TreeNode root, int sum) {
		HashSet<Integer> b = new HashSet<>();
		inOrder(root, b);

		Iterator<Integer> itr = b.iterator();
		while (itr.hasNext()) {
			int c = itr.next();
			if (b.contains(sum - c))
				return true;
		}

		return false;
	}

	public static void main(String args[]) {
		TreeNode root = new TreeNode(76);
		root.left = new TreeNode(67);
		root.right = new TreeNode(128);
		root.left.left = new TreeNode(23);
		root.left.right = new TreeNode(70);
		root.right.right = new TreeNode(200);
		System.out.println("Sum present: " + isSumPresent(root, 93));
	}

}
