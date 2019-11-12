package tree;

public class PrintTreeBoundaryAntiClockWise {

	static void printLeftBoundary(TreeNode root) {
		if (root != null) {
			if (root.left != null) {
				System.out.print(root.data + "  ");
				printLeftBoundary(root.left);
			} else if (root.right != null) {
				System.out.print(root.data + "  ");
				printLeftBoundary(root.right);
			}
		}
	}

	static void printRightBoundary(TreeNode root) {
		if (root != null) {
			if (root.right != null) {
				printLeftBoundary(root.right);
				System.out.print(root.data + "  ");
			} else if (root.left != null) {
				printLeftBoundary(root.left);
				System.out.print(root.data + "  ");
			}
		}
	}

	static void printLeaves(TreeNode root) {
		if (root != null) {
			printLeaves(root.left);
			if (root.left == null && root.right == null) {
				System.out.print(root.data + "  ");
			}
			printLeaves(root.right);
		}
	}

	static void treeBoundaryAntiClockWise(TreeNode root) {
		if (root != null) {
			System.out.print(root.data + "  ");
			printLeftBoundary(root.left);
			printLeaves(root.left);
			printLeaves(root.right);
			printRightBoundary(root.right);
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

		treeBoundaryAntiClockWise(root);
	}

}
