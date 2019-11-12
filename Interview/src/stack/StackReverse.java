package stack;

import java.util.Stack;

public class StackReverse {
	static Stack<Integer> s = new Stack<>();
	static void insertAtBottam(int tp) {
		if(s.size()==0)
			s.push(tp);
		else {
			int x = s.pop();
			insertAtBottam(tp);
			s.push(x);
		}
		
	}
	static void reverse() {
		if(s.size()>0) {
			int tp = s.pop();
			reverse();
			insertAtBottam(tp);
		}
	}
	public static void main(String args[]) {
		s.push(2);
		s.push(6);
		s.push(10);
		s.push(11);
		reverse();
		while(!s.isEmpty())
			System.out.println(s.pop());
	}
}
