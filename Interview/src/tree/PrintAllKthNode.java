package tree;

public class PrintAllKthNode {
	static class tree {
		int data;
		tree left, right;

		tree(int data) {
			this.data = data;
		}
	}

	static void printAllKthNode(tree root, int k) {
		if (root == null)
			return;
		if (k == 0) {
			System.out.print(root.data + " ");
			return;
		}
		printAllKthNode(root.left, k - 1);
		printAllKthNode(root.right, k - 1);

	}

	public static void main(String[] args) {
		tree root = new tree(1);
		root.left = new tree(2);
		root.right = new tree(3);
		root.left.left = new tree(4);
		root.right.left = new tree(8);
		int k = 2;
		printAllKthNode(root, k);
	}
}
