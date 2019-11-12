package sorting;

public class InsertionSort {

	static void insertionSort(int[] arr) {
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			int j = i - 1;
			int key = arr[i];
			while (j >= 0 && key < arr[j]) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
	}

	static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		int[] shubham = { 23, 1, 2, 87, 9, -9 };
		printArr(shubham);
		insertionSort(shubham);
		printArr(shubham);

	}

}
