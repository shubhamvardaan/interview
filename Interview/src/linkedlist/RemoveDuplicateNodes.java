package linkedlist;

public class RemoveDuplicateNodes {
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	static void printList(Node head) {
		Node current = head;
		while (current != null) {
			System.out.print(current.data + "  ");
			current = current.next;
		}
		System.out.println();
	}

	static void removeDuplicate(Node head) {
		Node current = head;
		Node temp = null;
		Node temp1 = null;
		Node prev = null;
		while (current != null) {
			temp = current;
			temp1 = current.next;
			prev = null;
			while (temp1 != null) {

				if (temp.data == temp1.data && temp1 == temp.next)
					temp.next = temp1.next;
				else if (temp.data == temp1.data) {
					prev.next = temp1.next;
				}
				if (temp1.next != null && temp1.data != temp1.next.data)
					prev = temp1;
				temp1 = temp1.next;

			}
			current = current.next;

		}
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(1);
		head.next.next = new Node(1);
		head.next.next.next = new Node(1);
		head.next.next.next.next = new Node(1);
		head.next.next.next.next.next = new Node(1);
		head.next.next.next.next.next.next = new Node(1);
		head.next.next.next.next.next.next.next = new Node(1);
		head.next.next.next.next.next.next.next.next = new Node(1);
		head.next.next.next.next.next.next.next.next.next = new Node(1);
		head.next.next.next.next.next.next.next.next.next.next = new Node(1);
		head.next.next.next.next.next.next.next.next.next.next.next = new Node(1);
		head.next.next.next.next.next.next.next.next.next.next.next.next = new Node(1);
		removeDuplicate(head);
		printList(head);

	}
}
