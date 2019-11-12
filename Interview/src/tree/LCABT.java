package tree;

public class LCABT {
	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
		}
	}

	static Node LCA(Node root, int a, int b) {
		if (root == null)
			return root;
		if (root.data == a || root.data == b)
			return root;
		Node left = LCA(root.left, a, b);
		Node right = LCA(root.right, a, b);

		if (left != null && right != null)
			return root;
		return left != null ? left : right;
	}

	public static void main(String[] args) {
		Node root = new Node(3);
		root.right = new Node(5);
		root.left = new Node(8);
		root.left.left = new Node(32);
		root.left.right = new Node(65);
		root.right.right = new Node(87);
		System.out.println(LCA(root, 8, 5).data);
	}
}
