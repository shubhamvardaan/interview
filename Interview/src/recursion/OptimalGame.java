package recursion;

public class OptimalGame {

	static class shubham {
		int maxPoint = 0;
	}

	static int maximum(int arr[], int low, int high) {
		return arr[low] >= arr[high] ? low : high;
	}

	static int optimalGame(int arr[], int low, int high, shubham s) {
		if (low + 1 == high)
			return arr[maximum(arr, low, high)];

		int index = maximum(arr, low, high);
		if (index == low) {
			s.maxPoint += arr[low];
			low++;
			if (arr[low] >= arr[high]) {
				low++;

			} else
				high--;

			s.maxPoint += optimalGame(arr, low, high, s);
		} else {
			s.maxPoint += arr[high];
			high--;
			if (arr[low] >= arr[high]) {
				low++;

			} else
				high--;
			s.maxPoint += optimalGame(arr, low, high, s);
		}
		return s.maxPoint;
	}

	public static void main(String[] args) {
		int[] arr = { 20, 30, 2, 2, 2, 10 };
		int low = 0;
		int high = arr.length - 1;
		shubham s = new shubham();
		System.out.println(optimalGame(arr, 0, arr.length - 1, s));
	}

}
