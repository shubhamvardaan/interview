package tree;

public class RemoveHalfNode {
	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
		}

	}

	static void inOrder(Node root) {
		if (root == null)
			return;
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}

	static Node removeHalfNode(Node root) {
		if (root == null)
			return null;
		root.left = removeHalfNode(root.left);
		root.right = removeHalfNode(root.right);
		if (root.left != null && root.right != null)
			return root;
		if (root.left == null)
			return root.right;
		if (root.right == null)
			return root.left;
		return root;

	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.right.right = new Node(4);
		inOrder(root);
		removeHalfNode(root);
		System.out.println();
		inOrder(root);
	}
}
