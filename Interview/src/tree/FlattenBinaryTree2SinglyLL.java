package tree;

public class FlattenBinaryTree2SinglyLL {

	static void flatten(TreeNode root) {
		if (root == null || root.left == null && root.right == null)
			return;
		if (root.left != null) {
			flatten(root.left);
			TreeNode temp = root.right;
			root.right = root.left;
			root.left = null;

			TreeNode t = root.right;
			while (t.right != null) {
				t = t.right;
			}
			t.right = temp;
		}

		flatten(root.right);

	}

	static void inOrder(TreeNode root) {
		if (root == null)
			return;
		inOrder(root.left);
		System.out.print(root.data + "  ");
		inOrder(root.right);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(69);
		root.left = new TreeNode(54);
		root.right = new TreeNode(70);
		root.right.right = new TreeNode(61);
		// root.left.right = new TreeNode(11);
		// root.left.left = new TreeNode(9);
		// root.right.left = new TreeNode(8);

		flatten(root);
		inOrder(root);
	}

}
