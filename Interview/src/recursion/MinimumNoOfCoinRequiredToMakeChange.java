package recursion;

public class MinimumNoOfCoinRequiredToMakeChange {
	static int minCoins(int arr[], int n, int sum) {
		if (sum == 0)
			return 0;
		int res = Integer.MAX_VALUE;
		int temp = -1;
		for (int i = 0; i < n; i++) {
			if (arr[i] <= sum)
				temp = minCoins(arr, n, sum - arr[i]);
			if (temp + 1 < res)
				res = temp + 1;
		}

		return res;
	}

	public static void main(String[] args) {
		int arr[] = { 1,2,3 };
		System.out.println(minCoins(arr, arr.length, 5));
	}
}
