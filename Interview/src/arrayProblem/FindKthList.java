package arrayProblem;

import java.util.PriorityQueue;

public class FindKthList {
	static int[] findArray(int[] arr, int k) throws IllegalArgumentException {
		if (k <= 0 || k > arr.length)
			throw new IllegalArgumentException("array size is not valid");
		int[] temp = new int[k];
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int x : arr) {
			pq.add(x);
		}
		int count = 0;
		while (!pq.isEmpty() && count < k) {
			temp[count] = pq.poll();
			count++;
		}
		return temp;
	}

	public static void main(String[] args) {
		int[] array = { 5, 1, 4, 4, 5, 9, 7, 13, 3 };
		int k = 3;
		System.out.println(findArray(array, k));
	}
}
