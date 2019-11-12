package tree;

class shubham {
	int element = -1;
}

public class BSTCheck {
	static boolean isBST(TreeNode root, int min, int max) {
		if (root == null)
			return true;
		if (root.data < min || root.data > max)
			return false;
		return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);

	}

	static boolean bstTree(TreeNode root) {
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	static boolean isBSTTreeUtil(TreeNode root, shubham s) {
		if (root == null)
			return true;
		isBSTTreeUtil(root.left, s);
		if (s.element < root.data) {
			s.element = root.data;
		} else
			return false;
		return isBSTTreeUtil(root.right, s);
	}

	static boolean isBSTTree(TreeNode root) {
		shubham s = new shubham();
		return isBSTTreeUtil(root, s);
	}

	public static void main(String args[]) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(2);
		root.right = new TreeNode(4);
		root.left.right= new TreeNode(100);
		System.out.println(isBSTTree(root));
	}

}
