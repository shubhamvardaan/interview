package tree;

import java.util.Arrays;

class constant {
	int count=0;
}

public class BinaryTreeToBST {

	static int treeSize(TreeNode root) {
		if (root == null)
			return 0;
		return 1 + treeSize(root.left) + treeSize(root.right);
	}

	static void treeToArray(TreeNode root, int[] arr, constant c) {
		if (root == null)
			return;
		arr[c.count] = root.data;
		c.count++;
		treeToArray(root.left, arr, c);
		treeToArray(root.right, arr, c);
	}

	static void arrayToTree(TreeNode root, int[] arr, constant c) {
		if (root == null)
			return;
		root.data = arr[c.count];
		c.count++;
		arrayToTree(root.left, arr, c);
		arrayToTree(root.right, arr, c);
	}

	static void binaryTreeToBST(TreeNode root) {
		int length = treeSize(root);
		int arr[] = new int[length];
		constant c = new constant();
		treeToArray(root, arr, c);
		Arrays.sort(arr);
		c.count = 0;
		arrayToTree(root, arr, c);
	}

	static void inOrder(TreeNode root) {
		if (root == null)
			return;
		System.out.print(root.data + " ");
		inOrder(root.left);
		inOrder(root.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(69);
		root.left = new TreeNode(54);
		root.right = new TreeNode(70);
		root.right.right = new TreeNode(61);
		root.left.right = new TreeNode(11);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(8);
		inOrder(root);
		System.out.println();
		binaryTreeToBST(root);
		inOrder(root);

	}

}
