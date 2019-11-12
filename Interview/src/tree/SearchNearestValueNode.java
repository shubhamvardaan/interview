package tree;

public class SearchNearestValueNode {
	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
		}
	}

	static class temp {
		Node node = null;
		int min = Integer.MAX_VALUE;
	}

	static Node findNodeBST(Node root, int key) {
		if (root == null)
			return null;
		if (root.data == key)
			return root;
		if (key < root.data)
			return findNodeBST(root.left, key);
		else
			return findNodeBST(root.right, key);
	}

	static void findNearestNode(Node root, int key, temp t) {
		if (root == null)
			return;
		if (t.min > Math.abs(root.data - key)) {
			t.min = Math.abs(root.data - key);
			t.node = root;
		}
		if (key < root.data)
			findNearestNode(root.left, key, t);
		if (root.data < key)
			findNearestNode(root.right, key, t);

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
		int k = 18;
		temp t = new temp();
		findNearestNode(root, k, t);
		System.out.println(t.node.data);
	}
}
