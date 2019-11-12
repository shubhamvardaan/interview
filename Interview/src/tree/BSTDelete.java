package tree;

public class BSTDelete {
	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

	static Node root;

	static void inOrder(Node root) {
		if (root == null)
			return;
		inOrder(root.left);
		System.out.print(root.data + "  ");
		inOrder(root.right);
	}

	static Node insert(Node root, int data) {
		if (root == null)
			return new Node(data);
		if (data < root.data)
			root.left = insert(root.left, data);
		else if (root.data < data)
			root.right = insert(root.right, data);
		return root;
	}

	static Node findMin(Node root) {
		Node current = root;
		while (current != null && current.left != null)
			current = current.left;
		return current;
	}

	static Node delete(Node root, int data) {
		if (root == null)
			return root;
		else if (data < root.data)
			root.left = delete(root.left, data);
		else if (root.data < data)
			root.right = delete(root.right, data);
		else {
			if (root.right == null) {
				return root.left;
			}
			if (root.left == null) {
				return root.right;
			}

			Node temp = findMin(root.right);
			root.data = temp.data;
			root.right = delete(root.right, temp.data);

		}
		return root;
	}

	public static void main(String args[]) {
		int[] shubham = { 11, 2, 34, 76, 9, 1, 22, 97, 53, 26, 35, 87 };
		for (int i = 0; i < shubham.length; i++)
			root = insert(root, shubham[i]);
		inOrder(delete(root, 22));

	}

}
