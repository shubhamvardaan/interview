package stack;

import java.util.Stack;

public class NextGreaterElement {
	static void nextGreaterElement(int arr[]) {
		Stack<Integer> s = new Stack<>();
		int count = 1;
		int len = arr.length;
		int temp;
		s.push(arr[0]);
		while (count < len) {
			temp = arr[count];
			while (!s.isEmpty() && s.peek() < temp)
				System.out.println(s.pop() + " " + temp);
			s.push(temp);
			count++;
		}

		while (!s.isEmpty()) {
			System.out.println(s.pop() + "  " + "-1");
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {11, 13, 21, 3};
		nextGreaterElement(arr);
		
	}
}
