package tree;

public class DiameterOfTree {

	static int maximum(int a, int b) {
		return a > b ? a : b;
	}

	static private int height(TreeNode root) {
		if (root == null)
			return 0;
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		return maximum(leftHeight, rightHeight) + 1;
	}

	static int diameterBinaryTree(TreeNode root) {
		if (root == null)
			return 0;
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		int leftDiameter = diameterBinaryTree(root.left);
		int rightDiameter = diameterBinaryTree(root.right);
		return maximum(maximum(leftDiameter, rightDiameter), 1 + leftHeight + rightHeight);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.right.left = new TreeNode(6);
		root.left.right.left.right = new TreeNode(7);
		root.left.left.left = new TreeNode(8);
		System.out.println("Diameter of Tree: " + diameterBinaryTree(root));

	}

}
