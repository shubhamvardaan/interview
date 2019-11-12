package arrayProblem;

public class SegragateNegativePostiveMaintainInsertionOrder {
	static void printArr(int[] arr) {
		for (int x : arr) {
			System.out.print(x + "  ");
		}
	}

	static public void swap(int[] arr, int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}

	static void reverse(int[] arr, int low, int high) {
		while (low < high) {
			swap(arr, low, high);
			low++;
			high--;
		}
	}

	static void merge(int[] arr, int low, int mid, int high) {
		int i = low;
		int j = mid + 1;
		while (i <= mid && arr[i] < 0)
			i++;
		while (j <= high && arr[j] < 0)
			j++;
		reverse(arr, i, mid);
		reverse(arr, mid + 1, j - 1);
		reverse(arr, i, j - 1);
	}

	public static void segregate(int[] arr, int low, int high) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			segregate(arr, low, mid);
			segregate(arr, mid + 1, high);
			merge(arr, low, mid, high);
		}
		
	}

	public static void main(String[] args) {
		int[] arr = { 2, -11, 9, 43, -7, 9, 90, 23, -100 };
		segregate(arr, 0, arr.length - 1);
		printArr(arr);
	}
}
