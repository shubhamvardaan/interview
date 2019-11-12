package recursion;

public class CoinChangeRecursive {
	static int count(int S[], int m, int n) {
		if (n == 0)
			return 1;
		if (n < 0)
			return 0;

		if (m <= 0 && n >= 1)
			return 0;
		return count(S, m - 1, n) + count(S, m, n - S[m - 1]);
	}

	public static void main(String[] args) {
		int arr[] = { 1, 5, 6, 9 };
		System.out.println(count(arr, arr.length, 11));
	}
}
