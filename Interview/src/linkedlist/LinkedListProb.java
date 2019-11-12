package linkedlist;

public class LinkedListProb {

	static class LinkedList {
		int data;
		LinkedList next;
		LinkedList random;

		LinkedList(int data) {
			this.data = data;
			next = null;
		}
	}

	static void printList(LinkedList head) {
		while (head != null) {
			System.out.print(head.data + "  ");
			head = head.next;
		}
		System.out.println();
	}

	static LinkedList cloneLinkedList(LinkedList head) {
		LinkedList current = head;
		LinkedList temp = null;
		while (current != null) {
			temp = current.next;
			current.next = new LinkedList(current.data);
			current.next.next = temp;
			current = temp;
		}
		current = head;
		while (current != null) {
			current.next.random = current.random.next;
			current = current.next.next;
		}
		temp = null;
		current = head;

		LinkedList head1=null;
		while (current != null) {
			if (temp == null)
				head1=temp = current.next;
			else {
				temp.next = current.next;
				temp = temp.next;
			}
			current.next = current.next.next;
			current = current.next;
		}

		printList(head1);
		return head;
	}

	public static void main(String args[]) {

		LinkedList head = new LinkedList(1);
		head.next = new LinkedList(2);
		head.next.next = new LinkedList(3);
		head.next.next.next = new LinkedList(4);
		head.next.next.next.next= new LinkedList(5);
		head.random = head.next.next;  
		  
	    // 2's random points to 1  
	    head.next.random = head;  
	  
	    // 3's and 4's random points to 5  
	    head.next.next.random = head.next.next.next.next;  
	    head.next.next.next.random = head.next.next.next.next;  
	  
	    // 5's random points to 2  
	    head.next.next.next.next.random = head.next;
		cloneLinkedList(head);

	}
}
