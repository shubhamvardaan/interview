package linkedlist;

public class ReverseAlternate {

	static class LinkedList {
		int data;
		LinkedList next;

		LinkedList(int data) {
			this.data = data;
			this.next = null;
		}
	}

	static void printList(LinkedList head) {
		LinkedList current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
	}

	static LinkedList reverse(LinkedList head, int k) {
		if(head==null)
			return null;
		LinkedList current = head;
		LinkedList next = null;
		LinkedList temp = null;
		int count = 0;
		while (current != null && count < k) {
			next = current.next;
			current.next = temp;
			temp = current;
			current = next;
			count++;
		}
		head.next = reverse(current,k);
		return temp;
	}

	public static void main(String args[]) {
		LinkedList head = new LinkedList(1);
		head.next = new LinkedList(2);
		head.next.next = new LinkedList(3);
		head.next.next.next = new LinkedList(4);
		head.next.next.next.next = new LinkedList(5);
		head.next.next.next.next.next = new LinkedList(6);
		head.next.next.next.next.next.next = new LinkedList(7);
		head.next.next.next.next.next.next.next = new LinkedList(8);
		head.next.next.next.next.next.next.next.next = new LinkedList(9);
		head.next.next.next.next.next.next.next.next.next = new LinkedList(10);
		head.next.next.next.next.next.next.next.next.next.next = new LinkedList(11);

		printList(reverse(head,5));

	}
}
