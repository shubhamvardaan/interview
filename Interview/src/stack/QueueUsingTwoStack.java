package stack;

import java.util.Stack;

public class QueueUsingTwoStack {

	private Stack<Integer> s1 = new Stack<>();
	private Stack<Integer> s2 = new Stack<>();

	void enque(int element) {
		s1.push(element);
	}

	int deque() {
		while (!s1.isEmpty())
			s2.push(s1.pop());
		int item = s2.pop();
		while (!s2.isEmpty())
			s1.push(s2.pop());
		return item;
	}

	public static void main(String[] args) {
		QueueUsingTwoStack queue = new QueueUsingTwoStack();
		queue.enque(12);
		queue.enque(5);
		queue.enque(52);
		queue.enque(17);
		System.out.println(queue.deque());
		queue.enque(23);
		System.out.println(queue.deque());
	}

}
