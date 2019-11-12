package arrayProblem;

import java.util.Stack;

public class PrintMaxInSubArray_k {

	static void printMaxInSubArray_k(int arr[], int n, int k) {
		if (n < k) {
			System.out.println("invalid input");
			return;
		}
		Stack<Integer> stk = new Stack<>();

		int stack_max = arr[0];
		stk.push(stack_max);
		int maxIndex = 0;
		for (int i = 1; i < k; i++) {
			if (stk.peek() < arr[i]) {
				stk.pop();
				stk.push(arr[i]);
				maxIndex = i;
			}
		}

		System.out.print(stk.peek() + " ");
		for (int i = k; i < n; i++) {

			if (maxIndex <= i - k) {
				stk.pop();
				stk.push(arr[i]);
			}
			if (stk.peek() < arr[i]) {
				stk.pop();
				stk.push(arr[i]);
			}
			System.out.print(stk.peek() + " ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 12, 1, 78, 90, 57, 89, 56 };
		int n = arr.length;
		printMaxInSubArray_k(arr, n, 3);

	}

}
