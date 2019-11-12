package tree;

public class InOrderSuccessor {
	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

	static Node findMin(Node root) {
		Node current = root;
		while (current != null && current.left != null)
			current = current.left;
		return current;

	}

	static Node searchBST(Node root, int node) {
		if (root == null)
			return null;
		if (root.data == node)
			return root;
		else if (root.data < node)
			return searchBST(root.left, node);
		else
			return searchBST(root.right, node);
	}

	static Node inOrderSucc(Node root, int node) {
		Node current = root;
		Node temp = null;
		if (searchBST(root, node) != null)
			return findMin(searchBST(root, node).right);
		while (current.data != node) {
			if (current.data < node) {
				current = current.right;
			} else if (current.data > node) {
				temp = current;
				current = current.left;
			}
		}
		return temp;
	}

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(5);
		root.left.left = new Node(3);
		root.left.right = new Node(7);
		root.right = new Node(23);
		System.out.println(inOrderSucc(root, 23).data);
	}
}
