package miscelleneous;

import java.util.Arrays;

public class CombSort {
	public static final float SHRINK_FACTOR = 1.3f;

	private static void swap(int arr[], int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static void combSort(int[] arr) {
		if (arr == null || arr.length < 2)
			return;
		int n = arr.length;
		int gap = n;
		boolean swapped = false;
		do {

			gap = (int) (gap / SHRINK_FACTOR);
			for (int i = 0; i < n - gap; i++) {
				if (arr[i] > arr[i + gap]) {
					swap(arr, i, i + gap);
					swapped = true;
				}
			}

		} while (gap > 1 && swapped);
	}

	public static void main(String args[]) {
		int[] array = { 50, 10, 25, -45, 30, 28 };
		combSort(array);
		System.out.println(Arrays.toString(array));
	}

}
