package linkedlist;

public class PairwiseSwapLL {

	static class LL {
		int data;
		LL next;

		LL(int data) {
			this.data = data;
			this.next = null;
		}
	}

	static void printList(LL head) {
		LL current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	static LL pairwiseSwap(LL head) {
		if (head == null || head.next == null)
			return head;
		else {
			LL temp = head.next;
			head.next = temp.next;
			temp.next = head;
			head = temp;
			head.next.next = pairwiseSwap(head.next.next);
			return head;
		}
	}

	public static void main(String[] args) {
		LL head = new LL(1);
		head.next = new LL(2);
		head.next.next = new LL(3);
		head.next.next.next = new LL(4);
		printList(pairwiseSwap(head));
	}

}
