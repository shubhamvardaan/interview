package miscelleneous;

public class NextWord {
	static void reverse(int[] arr, int low, int high) {
		int temp;
		while (low < high) {
			temp = arr[low];
			arr[low] = arr[high];
			arr[high] = temp;
			low++;
			high--;
		}
	}

	static void swap(int[] arr, int low, int high) {
		int temp = arr[low];
		arr[low] = arr[high];
		arr[high] = temp;
	}

	static void nextWord(int[] arr) {
		int index = -1;
		int index1 = -1;

		int len = arr.length;

		int i = 0;
		for (i = len - 1; i > 0; i--) {
			if (arr[i - 1] < arr[i]) {
				index = i - 1;
				break;
			}
		}

		int min = Integer.MAX_VALUE;
		for (i = len - 1; i > index; i--) {
			if (min > Math.abs(arr[i] - arr[index])) {
				min = Math.abs(arr[i] - arr[index]);
				index1 = i;
			}
		}
		swap(arr, index, index1);
		reverse(arr, index + 1, arr.length - 1);
	}

	public static void main(String[] args) {
		int[] arr = { 5, 3, 4, 9, 7, 6 };
		nextWord(arr);
	}

}
