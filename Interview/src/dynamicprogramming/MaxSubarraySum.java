package dynamicprogramming;

public class MaxSubarraySum {

	static int maxSubarraySum(int[] arr) {
		boolean allNegative = true;
		int maxNegativeSum = Integer.MIN_VALUE;
		int currSum = 0;
		int maxSum = Integer.MIN_VALUE;
		int length = arr.length;
		for (int i = 0; i < length; i++) {
			if (allNegative && arr[i] > 0) {	
				allNegative = false;
			} else if (allNegative && arr[i] < 0 && maxNegativeSum < arr[i]) {
				maxNegativeSum = arr[i];
			}
			currSum = currSum + arr[i];
			if (currSum < 0)
				currSum = 0;
			if (maxSum < currSum)
				maxSum = currSum;
		}

		return allNegative ? maxNegativeSum : maxSum;
	}

	public static void main(String args[]) {
		int[] arr = { 2, -9, 5, 1, -4, 6, 0, -7, 8 };
		System.out.println(maxSubarraySum(arr));
	}

}
