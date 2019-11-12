package linkedlist;

public class MergeSortedLinkedList {

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	static Node merge(Node a, Node b) {
		Node result = null;
		Node head = null;
		Node head1 = a;
		Node head2 = b;
		while (head1 != null && head2 != null) {
			if (head1.data < head2.data) {
				if (result == null) {
					head=result = head1;
				}
				else {
					result.next = head1;
					result = result.next;
				}
				head1 = head1.next;
			} else {
				if (result == null) {
					head=result = head2;
				}
					
				else {
					result.next = head2;
					result = result.next;
				}
				head2 = head2.next;
			}

		}
		while (head1 != null) {
			result.next = head1;
			head1 = head1.next;
			result = result.next;
		}
		while (head2 != null) {
			result.next = head2;
			result = result.next;
			head2 = head2.next;
		}
		return head;
	}

	static void printList(Node head) {
		Node current = head;
		while (current != null) {
			System.out.println(current.data + "  ");
			current = current.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node a = new Node(3);
		a.next = new Node(10);
		a.next.next = new Node(13);

		Node b = new Node(1);
		b.next = new Node(6);
		b.next.next = new Node(23);
		b.next.next.next = new Node(27);
		printList(merge(a, b));

	}

}
