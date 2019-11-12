package tree;

public class LevelOrderTraversalRecur {

	static int height(TreeNode root) {
		if (root == null)
			return 0;
		int l = height(root.left);
		int r = height(root.right);
		return l < r ? 1 + r : 1 + l;
	}

	static void printLevelOrderRecur(TreeNode root, int level) {
		if (root == null)
			return;
		if (level == 1)
			System.out.print(root.data + " ");
		else if (level > 1) {
			printLevelOrderRecur(root.left, level - 1);
			printLevelOrderRecur(root.right, level - 1);
		}
	}

	static void printLevelOrder(TreeNode root) {
		int h = height(root);
		for (int i = 1; i <= h; i++) {
			printLevelOrderRecur(root, i);
		}

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		printLevelOrder(root);
	}
}
