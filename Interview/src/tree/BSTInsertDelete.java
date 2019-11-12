package tree;

public class BSTInsertDelete {

	private static TreeNode findMin(TreeNode root) {
		TreeNode current = root;
		while (current.left != null) {
			current = current.left;
		}
		return current;
	}

	static TreeNode insert(TreeNode root, int key) {
		if (root == null)
			root = new TreeNode(key);
		if (key < root.data) {
			root.left = insert(root.left, key);
		} else if (key > root.data) {
			root.right = insert(root.right, key);
		}
		return root;
	}

	static TreeNode delete(TreeNode root, int key) {
		if (root == null)
			return root;
		if (key < root.data) {
			root.left = delete(root.left, key);
		} else if (key > root.data) {
			root.right = delete(root.right, key);
		} else {
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				root = root.left;
			}
			root.data = findMin(root.right).data;
			root.right = delete(root.right, root.data);
		}
		return root;
	}

	static void inOrder(TreeNode root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.data + "  ");
			inOrder(root.right);
		}
	}

	public static void main(String[] args) {
		TreeNode root = null;
		root = insert(root, 23);
		root = insert(root, 43);
		root = insert(root, 12);
		root = insert(root, 5);
		root = insert(root, 15);
		root = delete(root, 5);
		inOrder(root);

	}

}
