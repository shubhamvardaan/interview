package dynamicprogramming;

public class OptimalNumberOfJump {

	static int optimalNoOfJump(int[] arr) {
		int n = arr.length;
		if (n == 0 || arr[0] == 0)
			return Integer.MAX_VALUE;
		int[] jumps = new int[n];
		jumps[0] = 0;
		for (int i = 1; i < n; i++) {
			jumps[i] = Integer.MAX_VALUE;
			for (int j = 0; j < i; j++) {
				if (arr[j] >= (i - j)) {
					if ((jumps[j] + 1) < jumps[i]) {
						jumps[i] = jumps[j] + 1;
					}

				}
			}
		}
		return jumps[n - 1];
	}

	public static void main(String[] args) {
		int[] arr = { 2, 3, 1, 1, 4 };
		System.out.println(optimalNoOfJump(arr));
	}
}
