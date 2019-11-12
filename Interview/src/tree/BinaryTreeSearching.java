package tree;

public class BinaryTreeSearching {
	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
		}
	}

	static boolean search(Node root, int data) {
		boolean temp = false;
		if (root == null)
			return false;
		else {
			if (root.data == data)
				return true;
			else {
				temp = search(root.left, data);
				if (temp != false)
					return temp;
				return search(root.right, data);
			}

		}
	}

	public static void main(String[] args) {
		Node root = new Node(100);
		root.left = new Node(12);
		root.right = new Node(76);
		root.right.left = new Node(20);
		System.out.println(search(root, 20));
	}

}
