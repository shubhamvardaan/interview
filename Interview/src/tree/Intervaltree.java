package tree;

public class Intervaltree {
	static class Interval {
		int low, high;

		Interval(int low, int high) {
			this.low = low;
			this.high = high;
		}
	}

	static class Node {
		Interval i;
		int max;
		Node left, right;

		Node(Interval i) {
			this.i = i;
			max = Integer.MIN_VALUE;
		}
	}

	private static boolean isOverlapped(Interval one, Interval two) {
		if (one == null || two == null)
			return false;
		if (one.low <= two.high)
			return two.low <= one.high;

		return false;
	}

	public static void printOverlapping(Node root, Interval i) {
		if (root == null)
			return;
		if (isOverlapped(root.i, i)) {
			System.out.println(root.i.low + " " + root.i.high);
		}
		if (root.left == null && root.right != null)
			printOverlapping(root.right, i);
		if (root.left != null && i.low < root.left.max)
			printOverlapping(root.left, i);
		else if (root.right != null && root.left != null) {
			if (i.low > root.left.max)
				printOverlapping(root.right, i);
		}
	}

	public static Node insert(Node root, Interval interval) {
		if (root == null)
			root = new Node(interval);
		else if (interval.low < root.i.low)
			root.left = insert(root.left, interval);
		else
			root.right = insert(root.right, interval);

		if (root.max < interval.high)
			root.max = interval.high;
		return root;
	}

	public static void inorder(Node root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.println(root.i.low + " " + root.i.high + " " + "high :" + root.max);
		inorder(root.right);
	}

	public static void main(String[] args) {
		Node root = null;
		root = insert(root, new Interval(10, 15));
		root = insert(root, new Interval(13, 14));
		root = insert(root, new Interval(1, 3));
		root = insert(root, new Interval(4, 7));
		root = insert(root, new Interval(7, 10));
		root = insert(root, new Interval(15, 19));
		// inorder(root);
		printOverlapping(root, new Interval(2, 13));
	}
}
