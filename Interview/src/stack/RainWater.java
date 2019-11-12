package stack;

public class RainWater {

	static int maximum(int a, int b) {
		return a < b ? b : a;
	}

	static int minimum(int a, int b) {
		return a < b ? a : b;
	}

	static int rainWaterProb(int[] tower) {
		int length = tower.length;
		int[] right = new int[length];
		int result = 0;
		int rightMax = -1;
		int leftMax = -1;
		for (int i = length - 1; i >= 0; i--) {
			if (rightMax < tower[i]) {
				rightMax = tower[i];
				right[i] = rightMax;
			} else {
				right[i] = rightMax;
			}
		}
		for (int i = 0; i < length; i++) {

			if (leftMax < tower[i])
				leftMax = tower[i];
			result += minimum(right[i], leftMax) - tower[i];
		}
		return result;

	}

	public static void main(String[] args) {
		int[] tower = { 3, 0, 0, 2, 0, 4 };
		System.out.println(rainWaterProb(tower));
	}
}
