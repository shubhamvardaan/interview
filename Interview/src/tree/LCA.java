package tree;

public class LCA {

	static TreeNode getLCA(TreeNode root, TreeNode a, TreeNode b) {
		if (root == null)
			return null;
		if (root == a || root == b)
			return root;
		TreeNode left = getLCA(root.left, a, b);
		TreeNode right = getLCA(root.right, a, b);
		if (left != null && right != null)
			return root;
		return left != null ? left : right;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(69);
		root.left = new TreeNode(54);
		root.right = new TreeNode(70);
		root.right.right = new TreeNode(61);
		root.left.right = new TreeNode(11);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(8);
		System.out.println(getLCA(root, root.left.right, root.left.left).data);
	}
}
