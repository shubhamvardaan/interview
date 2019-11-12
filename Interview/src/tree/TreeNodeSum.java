package tree;

public class TreeNodeSum {

	static void preOrder(TreeNode root) {
		if (root == null)
			return;
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	static void nodeSum(TreeNode root) {
		if (root == null)
			return;
		nodeSum(root.left);
		nodeSum(root.right);
		int rootSum = root.data;
		if (root.left != null)
			rootSum += root.left.data;
		if (root.right != null)
			rootSum += root.right.data;
		root.data = rootSum;
	}

	public static void main(String args[]) {
		TreeNode root = new TreeNode(69);
		root.left = new TreeNode(54);
		root.right = new TreeNode(70);
//		root.right.right = new TreeNode(61);
//		root.left.right = new TreeNode(11);
//		root.left.left = new TreeNode(9);
//		root.right.left = new TreeNode(8);
		System.out.println("Orginal Tree :");
		preOrder(root);
		System.out.println();
		System.out.println("After change :");
		nodeSum(root);
		preOrder(root);
	}
}
