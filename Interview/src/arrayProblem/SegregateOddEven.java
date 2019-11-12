package arrayProblem;

public class SegregateOddEven {
	static void printArr(int[] array) {
		for (int x : array) {
			System.out.print(x + "  ");
		}
	}

	public static void merge(int[] array, int low, int mid, int high) {
		int m = mid - low + 1;
		int n = high - mid;
		int left[] = new int[m];
		int right[] = new int[n];
		for (int i = 0; i < m; i++) {
			left[i] = array[low + i];
		}
		for (int j = 0; j < n; j++) {
			right[j] = array[mid + 1 + j];
		}
		int i = 0, j = 0;
		int k = low;
		while (i < m && left[i] % 2 == 1) {
			array[k++] = left[i++];
		}

		while (j < n && right[j] % 2 == 1) {
			array[k++] = right[j++];
		}
		while (i < m)
			array[k++] = left[i++];
		while (j < n)
			array[k++] = right[j++];
	}

	public static void segregate(int[] array, int low, int high) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			segregate(array, low, mid);
			segregate(array, mid + 1, high);
			merge(array, low, mid, high);
		}
	}

	static void segregateOddEven(int[] array) {
		segregate(array, 0, array.length - 1);
		printArr(array);
	}

	public static void main(String[] args) {
		int[] arr = { 65, 8, 7, 18, 9, 87, 90, 12, 54, 42 };
		segregateOddEven(arr);
	}

}
