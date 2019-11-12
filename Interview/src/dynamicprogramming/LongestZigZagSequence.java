package dynamicprogramming;

public class LongestZigZagSequence {
	static int maximum(int a, int b) {
		return a < b ? b : a;
	}

	static int longestZigZagSequence(int[] arr) {
		int n = arr.length;
		int[][] shubham = new int[n][2];
		for (int i = 0; i < n; i++) {
			shubham[i][0] = 1;
			shubham[i][1] = 1;
		}
		int res = 1;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && shubham[i][0] < shubham[j][0] + 1) {
					shubham[i][0] = shubham[j][0] + 1;
				}
				if (arr[i] < arr[j] && shubham[i][1] < shubham[j][1] + 1) {
					shubham[i][1] = shubham[j][1] + 1;
				}
			}
			if (res < maximum(shubham[i][0], shubham[i][1])) {
				res = maximum(shubham[i][0], shubham[i][1]);
			}
		}
		return res;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 10, 22, 9, 33, 49, 50, 31, 60 };
		System.out.println("Length of Longest " + "Zig-Zag subsequence is " + longestZigZagSequence(arr));

	}

}
