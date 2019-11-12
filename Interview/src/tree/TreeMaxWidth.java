package tree;

public class TreeMaxWidth {

	static int arrayMax(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (max < arr[i])
				max = arr[i];
		}
		return max;
	}

	static int maximum(int a, int b) {
		return a < b ? a : b;
	}

	static int height(TreeNode root) {
		if (root == null)
			return 0;
		int left = height(root.left);
		int right = height(root.right);
		return 1 + (left > right ? left : right);

	}

	static void maxWidthUtil(TreeNode root, int[] shubham, int level) {
		if (root == null)
			return;
		shubham[level] = shubham[level] + 1;
		maxWidthUtil(root.left, shubham, level + 1);
		maxWidthUtil(root.right, shubham, level + 1);
	}

	static int maxWidth(TreeNode root) {
		int length = height(root);
		int[] shubham = new int[length];
		int level = 0;
		maxWidthUtil(root, shubham, level);
		return arrayMax(shubham);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(69);
		root.left = new TreeNode(54);
		root.right = new TreeNode(70);
		root.right.right = new TreeNode(61);
		root.left.right = new TreeNode(11);
		root.left.left = new TreeNode(9);
		// root.right.left = new TreeNode(8);
		System.out.println(maxWidth(root));
	}

}
