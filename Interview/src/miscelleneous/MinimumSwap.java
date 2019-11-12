package miscelleneous;

public class MinimumSwap {
	static boolean isSorted(int[] arr, int low, int high) {
		for (int i = low; i < high; i++) {
			if (arr[i] > arr[i + 1])
				return false;
		}
		return true;
	}

	static int findMinIndex(int arr[], int low, int high) {
		int min = Integer.MAX_VALUE;
		int index = -1;
		for (int i = low; i <= high; i++) {
			if (arr[i] < min) {
				min = arr[i];
				index = i;
			}
		}
		return index;
	}

	static void swap(int[] arr, int low, int high) {
		int temp = arr[low];
		arr[low] = arr[high];
		arr[high] = temp;
	}

	static int calculateDiff(int arr[]) {
		int sum = 0;
		for (int i = 0; i < arr.length - 1; i++)
			sum = sum + Math.abs(arr[i] - arr[i + 1]);
		return sum;
	}

	static int numberOfSwaps(int[] arr) {
		int len = arr.length;
		int minSwapCount = 0;
		int minSum = Integer.MAX_VALUE;
		for (int i = 0; i < len - 1; i++) {
			if (!isSorted(arr, i + 1, len - 1)) {
				swap(arr, i, findMinIndex(arr, i + 1, len - 1));
				int sum = calculateDiff(arr);
				if (minSum > sum) {
					minSum = sum;
					minSwapCount = minSwapCount + 1;
				}
					
			} else
				break;
		}
		return minSwapCount;
	}

	public static void main(String[] args) {
		int[] arr = { 3, 4, 2, 5, 1 };
		System.out.println(numberOfSwaps(arr));
	}

}
