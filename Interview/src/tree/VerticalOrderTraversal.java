package tree;

public class VerticalOrderTraversal {
	private static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
		}
	}

	private static class minmax {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
	}

	private static void calMinMax(Node root, int len, minmax m) {
		if (root == null)
			return;

		if (len < m.min)
			m.min = len;
		if (m.max < len)
			m.max = len;
		calMinMax(root.left, len - 1, m);
		calMinMax(root.right, len + 1, m);

	}

	private static void printVericalOrderUtil(Node root, int level, int distance) {
		if (root == null)
			return;
		if (level == distance)
			System.out.print(root.data + "  ");
		printVericalOrderUtil(root.left, level, distance - 1);
		printVericalOrderUtil(root.right, level, distance + 1);
	}

	static void printVericalOrder(Node root) {
		minmax m = new minmax();
		calMinMax(root, 0, m);
		for (int i = m.min; i <= m.max; i++) {
			printVericalOrderUtil(root, i, 0);
			System.out.println();
		}
	}

	public static void main(String args[]) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		printVericalOrder(root);
	}
}
