package tree;

public class PrintBoundayClockWiseTree {

	static void printLeaves(TreeNode root) {
		if (root != null) {
			printLeaves(root.right);
			if (root.left == null && root.right == null)
				System.out.println(root.data + " ");
			printLeaves(root.left);
		}
	}

	static void printRightBoundary(TreeNode root) {
		if (root != null) {
			if (root.right != null) {
				System.out.println(root.data + " ");
				printRightBoundary(root.right);
			} else if (root.left != null) {
				System.out.println(root.data + " ");
				printRightBoundary(root.left);
			}
		}
	}

	static void printleftBoundary(TreeNode root) {
		if (root != null) {
			if (root.left != null) {
				printRightBoundary(root.left);
				System.out.println(root.data + " ");
			} else if (root.right != null) {
				printRightBoundary(root.right);
				System.out.println(root.data + " ");
			}
		}
	}

	static void printClockwise(TreeNode root) {
		if (root != null) {
			System.out.println(root.data + " ");
			printRightBoundary(root.right);
			printLeaves(root.right);
			printLeaves(root.left);
			printleftBoundary(root.left);
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

		printClockwise(root);

	}

}
