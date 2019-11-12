package tree;


public class BInaryTreeToLinkedList {
	static class tree {
		int data;
		tree left, right;

		tree(int data) {
			this.data = data;
		}
	}

	static void preorder(tree root) {
		if (root == null)
			return;
		System.out.print(root.data + "  ");
		preorder(root.left);
		preorder(root.right);
	}

	static void treeToLinkedList(tree root) {
		if (root == null || (root.left == null && root.right == null))
			return;
		if (root.left != null) {
			treeToLinkedList(root.left);
			tree temp = root.right;
			root.right = root.left;
			root.left = null;
			tree t = root.right;
			while (t.right != null)
				t = t.right;
			t.right = temp;

		}

		treeToLinkedList(root.left);
	}

	public static void main(String[] args) {
		tree root = new tree(1);
		root.left = new tree(2);
		root.right = new tree(3);
		root.left.left = new tree(4);
		root.right.left = new tree(8);
		treeToLinkedList(root);
		preorder(root);
	}
}
