package linkedlist;

public class BinaryTreetoLinkedList {
	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

	static Node head;
	static Node prev = null;

	static void bt2LL(Node root) {
		if (root == null)
			return;

		bt2LL(root.left);
		if (prev == null)
			head = root;
		else {
			root.left = prev;
			prev.right = root;
		}
		prev = root;
		bt2LL(root.right);
	}

	static void printList(Node head) {
		Node current = head;
		while (current != null) {
			System.out.print(current.data);
			current = current.right;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		bt2LL(root);
		printList(head);
	}

}
