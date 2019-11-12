package stack;

public class RainWaterProblem {

	static int max(int a, int b) {
		return a > b ? a : b;
	}

	static int min(int a, int b) {
		return a < b ? a : b;
	}

	static int maxWater(int[] arr) {
		int water = 0;
		int length = arr.length;
		int[] left = new int[length];
		int[] right = new int[length];
		left[0] = arr[0];
		for (int i = 1; i < length; i++)
			left[i] = max(left[i - 1], arr[i]);
		right[length - 1] = arr[length - 1];
		for (int i = length - 2; i >= 0; i--)
			right[i] = max(right[i + 1], arr[i]);

		for (int i = 0; i < length; i++) {
			water = water + min(left[i], right[i]) - arr[i];
		}

		return water;

	}

	public static void main(String[] args) {

		int[] arr = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(maxWater(arr));
	}

}
