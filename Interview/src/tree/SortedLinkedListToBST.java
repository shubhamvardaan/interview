package tree;

public class SortedLinkedListToBST {

	static class LLNode {
		int data;
		LLNode next;

		LLNode(int data) {
			this.data = data;
		}
	}

	static LLNode head;

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
		System.out.print(root.data + "  ");
		inOrder(root.right);
	}

	static Node llToBSTRecur(int count) {
		if (count <= 0)
			return null;
		Node left = llToBSTRecur(count / 2);
		Node root = new Node(head.data);
		root.left = left;
		head = head.next;
		root.right = llToBSTRecur(count - count / 2 - 1);
		return root;
	}

	static Node sortedLLToBST(LLNode head) {
		int count = listLength(head);
		return llToBSTRecur(count);
	}

	static int listLength(LLNode head) {
		LLNode current = head;
		int len = 0;
		while (current != null) {
			len = len + 1;
			current = current.next;
		}

		return len;
	}

	static void printList(LLNode head) {
		LLNode current = head;
		while (current != null) {
			System.out.println(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		head = new LLNode(1);
		head.next = new LLNode(2);
		head.next.next = new LLNode(3);
		head.next.next.next = new LLNode(4);
		head.next.next.next.next = new LLNode(5);
		head.next.next.next.next.next = new LLNode(6);
		head.next.next.next.next.next.next = new LLNode(7);

		printList(head);

		int count = listLength(head);
		Node root = sortedLLToBST(head);
		inOrder(root);

	}

}
