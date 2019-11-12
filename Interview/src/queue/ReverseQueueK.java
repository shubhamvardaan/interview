package queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class ReverseQueueK {

	static Deque<Integer> queue = new LinkedList<>();

	static void printQueue(Deque<Integer> queue) {
		while (queue.size() != 0) {
			System.out.println(queue.pop());
		}
	}

	static void reverseFirstK(Deque<Integer> queue, int k) {
		int n = queue.size();
		int count = 0;
		if (n <= k)
			return;
		Stack<Integer> stack = new Stack<>();
		while (count < k) {
			stack.push(queue.pop());
			count++;
		}
		while (!stack.isEmpty())
			queue.push(stack.pop());
		count = 0;
		while (count < n - k) {
			queue.push(queue.pop());
			count++;
		}

	}

	public static void main(String args[]) {

		int[] arr = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };
		for (int i = 0; i < arr.length; i++)
			queue.push(arr[i]);
		reverseFirstK(queue, 4);
		printQueue(queue);
	}
}
