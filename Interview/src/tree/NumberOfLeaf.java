package tree;

public class NumberOfLeaf {
	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
		}
	}

	static class Count {
		int nodeCount = 0;
	}

	static void leafNodeCount(Node root, Count c) {
		if (root == null)
			return;
		if (root.left == null && root.right == null)
			c.nodeCount = c.nodeCount + 1;
		leafNodeCount(root.left, c);
		leafNodeCount(root.right, c);
	}

	public static void main(String[] args) {
		Node root = new Node(9);
		root.left = new Node(4);
		root.right = new Node(17);
		root.left.left = new Node(3);
		root.left.right = new Node(6);
		root.left.right.left = new Node(5);
		root.left.right.right = new Node(7);
		root.right.right = new Node(22);
		root.right.right.left = new Node(20);
		Count c = new Count();
		leafNodeCount(root, c);
		System.out.println(c.nodeCount);
	}
}
