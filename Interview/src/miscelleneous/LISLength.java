package miscelleneous;

public class LISLength {
	static int maximum(int[] lis) {
		int max = Integer.MIN_VALUE;
		for (int a : lis) {
			if (max < a)
				max = a;
		}
		return max;
	}

	static int LIS(int[] arr) {
		int n = arr.length;
		int[] lis = new int[n];
		lis[0] = 1;
		int i, j;
		for (i = 1; i < n; i++) {
			for (j = 0; j < i; j++) {
				if (arr[i] > arr[j] && lis[j] > lis[i])
					lis[i] = lis[j];
			}
			lis[i]++;
		}
		return maximum(lis);
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 5, 10, 7, 8, 11, 12, -1 };
		System.out.println(LIS(arr));
	}
}
