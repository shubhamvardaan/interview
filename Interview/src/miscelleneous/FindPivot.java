package miscelleneous;

public class FindPivot {
	static int findPivot(int arr[], int low, int high) {
		int mid = low + (high - low) / 2;
		if (arr[mid] > arr[mid + 1])
			return mid + 1;
		if (arr[low] <= arr[mid])
			return findPivot(arr, mid + 1, high);
		else
			return findPivot(arr, low, mid - 1);
	}

	public static void main(String args[]) {
		int arr[] = { 6, 7, 8, 9, 10, 11, 12 };
		System.out.println(findPivot(arr, 0, arr.length - 1));

	}

}
