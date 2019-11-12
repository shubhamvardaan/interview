package comparable_comparator;

public class PrintAllSubset {
	static boolean printAllSumRecur(int[] arr, int n, int sum) {
		if (sum == 0) {
			return true;
		}
		if (n == 0 || arr == null)
			return false;
		return printAllSumRecur(arr, n - 1, sum) || printAllSumRecur(arr, n - 1, sum - arr[n - 1]);
	}

	static boolean printAllSubSet(int[] arr, int sum) {
		return printAllSumRecur(arr, arr.length, sum);
	}

	public static void main(String[] args) {
		int arr[] = { 2, 5, 8, 4, 6, 11 };
		int sum = 5;
		System.out.println(printAllSubSet(arr, sum));
	}
}
