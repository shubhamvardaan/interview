package miscelleneous;

import java.util.Arrays;

public class PrintAllUniqueCombination {

	static void combinationRecur(int[] arr, int i, String output, int n, int k) {
		if (k > n)
			return;
		if (k == 0) {
			System.out.println(output);
			return;
		}
		
		for (int j = i; j < n; j++) {
			combinationRecur(arr, j+1, output + " " + arr[j], n, k - 1);
			while (j < n - 1 && arr[j] == arr[j + 1])
				j++;
		}
	}

	static void printUniqueCombination(int[] arr, int k) {
		String output = "";
		int n = arr.length;
		combinationRecur(arr, 0, output, n, k);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 1, 1, 1, 2, 1, 3, 4 };
		Arrays.sort(arr);
		printUniqueCombination(arr, 3);
	}

}
