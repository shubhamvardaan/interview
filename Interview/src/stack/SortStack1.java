package stack;

import java.util.Stack;

public class SortStack1 {

	static void sortStack(Stack<Integer> s) {
		Stack<Integer> temp = new Stack<>();

		while (!s.isEmpty()) {
			int top = s.pop();
			while (!temp.isEmpty() && temp.peek() > top)
				s.push(temp.pop());
			temp.push(top);

		}
		while (!temp.isEmpty())
			s.push(temp.pop());
	}

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);

		sortStack(s);

		while (!s.isEmpty())
			System.out.print(s.pop() + "  ");

	}

}
