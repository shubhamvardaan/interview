package arrayProblem;

public class ArraySegregateWithInsertionOrder {

	static void merge(int arr[], int low, int mid, int high) {
		int i, j, k;
		int m = mid - low + 1;
		int n = high - mid;
		int left[] = new int[m];
		int right[] = new int[n];
		for (i = 0; i < m; i++)
			left[i] = arr[low + i];
		for (j = 0; j < n; j++)
			right[j] = arr[mid + 1 + j];
		i = 0;
		j = 0;
		k = low;
		while (i < m && left[i] < 0)
			arr[k++] = left[i++];

		while (j < n && right[j] < 0)
			arr[k++] = right[j++];
		while (i < m)
			arr[k++] = left[i++];
		while (j < n)
			arr[k++] = right[j++];
	}

	static void segregate(int arr[], int low, int high) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			segregate(arr, low, mid);
			segregate(arr, mid + 1, high);
			merge(arr, low, mid, high);
		}
	}

	static void printArr(int arr[]) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + "  ");
	}

	public static void main(String args[]) {
		int arr[] = { 2, -11, 9, 43, -7, 9, 90, 23, -100 };
		int n = arr.length;
		segregate(arr, 0, n - 1);
		printArr(arr);
	}
}
