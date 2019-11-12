package tree;

public class PrintPath {

	static void printArray(int[] arr, int pathLen) {
		for (int i = 0; i < pathLen; i++) {
			System.out.print(arr[i] + "  ");
		}
		System.out.println();
	}

	static void printPathUtil(TreeNode root, int[] arr, int pathLen) {
		if (root == null)
			return;
		arr[pathLen++] = root.data;
		if (root.left == null && root.right == null) {
			printArray(arr, pathLen);
		}
		printPathUtil(root.left, arr, pathLen);
		printPathUtil(root.right, arr, pathLen);
	}

	static void printPath(TreeNode root) {
		int[] arr = new int[1000];
		int pathLen = 0;
		printPathUtil(root, arr, pathLen);
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

		printPath(root);

	}

}
