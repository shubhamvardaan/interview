package arrayProblem;

public class FindLast {

	static int findLast(int arr[], int n, int key) {
		int low = 0, high = n - 1;
		

		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (mid == high && arr[mid] == key || arr[mid + 1] > key)
				return mid;
			if (arr[mid] < key)
				low = mid + 1;
			else if(arr[mid]>key)
				high = mid - 1;
		}

		return -1;
	}

	public static void main(String args[]) {
		int arr[] = { 1, 2, 3, 4, 5, 5, 5, 5, 6, 7 };
		System.out.println(findLast(arr, arr.length, 5));
	}
}
