package miscelleneous;

public class LIS {
	static int lis(int[] arr, int i, int n, int prev) {
		if (i == n)
			return 0;
		int excl = lis(arr, i + 1, n, prev);
		int incl = 0;
		if (prev < arr[i])
			incl = 1 + lis(arr, i + 1, n, arr[i]);
		return Integer.max(excl, incl);
	}

	public static void main(String[] args) {
		int[] arr = { 1, 5, 2, 10, 8, 11, 7, 12 };
		System.out.println(lis(arr, 0, arr.length, Integer.MIN_VALUE));
	}
}
