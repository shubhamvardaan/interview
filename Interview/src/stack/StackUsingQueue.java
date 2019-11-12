package stack;

import java.util.Deque;
import java.util.LinkedList;

public class StackUsingQueue {

	static class Stack {
		Deque<Integer> q1 = new LinkedList<>();
		Deque<Integer> q2 = new LinkedList<>();

		void push(int x) {
			if (q1.isEmpty())
				q2.push(x);
			else
				q1.push(x);
		}

		int pop() {
			int data = -1;
			if (!q1.isEmpty()) {
				while (q1.size() != 1) {
					q2.push(q1.pop());
				}
				data = q1.pop();
			} else if (!q2.isEmpty()) {
				while (q2.size() != 1) {
					q1.push(q2.pop());
				}
				data = q2.pop();
			}
			return data;
		}
	}

	public static void main(String args[]) {
		Stack s = new Stack();
		s.push(2);
		s.push(23);
		s.push(12);
		System.out.println(s.pop());
	}

}
