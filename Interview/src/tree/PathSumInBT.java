package tree;

public class PathSumInBT {

	static class Node {
		int key;
		Node left, right;

		Node(int key) {
			this.key = key;
		}
	}

	static class Shubham {
		int sum = 0;
	}

	static void printPath(Node root, String str, Shubham shubham) {
		if (root == null)
			return;
		str = str + root.key;
		if (root.left == null && root.right == null) {
			// System.out.println(str);
			int sum = 0;
			for (int i = 0; i < str.length(); i++)
				sum = sum * 10 + Integer.valueOf(str.substring(i, i + 1));
			shubham.sum = shubham.sum + sum;
			return;
		} else {
			printPath(root.left, str, shubham);
			printPath(root.right, str, shubham);
		}

	}

	public static void main(String[] args) {

		Node root = new Node(3);
		root.left = new Node(6);
		root.right = new Node(7);
		root.left.right = new Node(8);
		root.right.left = new Node(9);
		root.right.right = new Node(10);
		Shubham shubham = new Shubham();
		printPath(root, "", shubham);
		System.out.println(shubham.sum);
	}

}
