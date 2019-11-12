package linkedlist;

import java.util.Random;

public class RandomNodeLinkedList {

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	static int getRandom(Node head) {
		int res = head.data;
		Node node = head.next;
		int count = 1;
		Random random = new Random();
		while (node != null) {
			++count;
			if (random.nextInt() % count == 0) {
				res = node.data;
			}
			node = node.next;
		}
		return res;
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		System.out.println(getRandom(head));

	}

}
