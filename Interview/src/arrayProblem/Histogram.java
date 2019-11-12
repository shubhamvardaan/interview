package arrayProblem;

import java.util.Stack;

public class Histogram {
	static int maxArea(int[] hist) {
		int n = hist.length;
		Stack<Integer> stack = new Stack<>();
		int maxArea = Integer.MIN_VALUE;
		int currArea = -1;
		int i = 0;
		int top;
		while (i < n) {
			if (stack.isEmpty() || hist[stack.peek()] <= hist[i]) {
				stack.push(i++);
			} else {
				top = stack.peek();
				stack.pop();
				currArea = hist[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
				if (maxArea < currArea) {
					maxArea = currArea;
				}

			}
		}
		while (!stack.isEmpty()) {
			top = stack.peek();
			stack.pop();
			currArea = hist[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
			if (maxArea < currArea) {
				maxArea = currArea;
			}
		}
		return maxArea;
	}

	public static void main(String[] args) {
		int[] arr = { 6, 2, 5, 4, 5, 1, 6 };
		System.out.println(maxArea(arr));
	}
}
