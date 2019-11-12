package stack;

import java.util.Stack;

public class AreaUnderHistogram {

	static int getArea(int[] hist) {
		Stack<Integer> s = new Stack();
		int current_area = -1;
		int max_area = -1;
		int n = hist.length;
		int i = 0;
		int top = -1;
		while (i < n) {
			if (s.empty() || hist[s.peek()] <= hist[i]) {
				s.push(i++);
			} else {
				top = s.pop();
				current_area = hist[top] * (s.empty() ? i : i - s.peek() - 1);
				if (max_area < current_area) {
					max_area = current_area;
				}
			}
		}

		while (!s.empty()) {
			top = s.pop();
			current_area = hist[top] * (s.empty() ? i : i - s.peek() - 1);
			if (max_area < current_area) {
				max_area = current_area;
			}
		}
		return max_area;
	}

	public static void main(String[] args) {
		int[] hist = { 6, 2, 5, 4, 5, 1, 6 };
		System.out.println(getArea(hist));

	}

}
