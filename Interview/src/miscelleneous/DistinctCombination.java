package miscelleneous;

import java.util.Arrays;

public class DistinctCombination {

	static void distinctCombinations(int[] input, String result, int n, int i, int k) {
		if (n < k)
			return;
		if (k == 0) {
			System.out.println(result);
			return;
		}

		for (int j = i; j < n; j++) {
			distinctCombinations(input, result + input[j], n, j + 1, k - 1);
			while (j < n - 1 && input[j] == input[j + 1])
				j++;
		}
	}

	static void printCombination(int input[], int k) {
		int n = input.length;
		Arrays.sort(input);
		distinctCombinations(input, "", n, 0, k);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] result = { 1, 2, 7, 1, 1, 1 };
		printCombination(result, 2);
	}
}
