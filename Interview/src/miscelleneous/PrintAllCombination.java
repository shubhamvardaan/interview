package miscelleneous;

public class PrintAllCombination {
	static void combUtil(int[] arr, int index, int i, int n, int r, int[] result) {
		if (index == r) {
			for (int x = 0; x < r; x++)
				System.out.print(result[x]);
			System.out.println();
			return;
		}
		if (i >= n)
			return;
		result[index] = arr[i];
		combUtil(arr, index + 1, i + 1, n, r, result);
		combUtil(arr, index, i + 1, n, r, result);
	}

	static void printAllCombination(int[] arr, int k) {
		int[] result = new int[k];
		combUtil(arr, 0, 0, arr.length, k, result);
	}

	public static void main(String[] args) {
		int[] shubham = { 1,1,1, 2, 3, 4 };
		printAllCombination(shubham, 3);
	}
}
