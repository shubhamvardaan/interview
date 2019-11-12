package miscelleneous;

public class SumInArray {
	static void printEle(int arr[], int sum) {
		int low = 0;
		int high = arr.length - 1;
		int temp;
		while (low < high) {
			temp = arr[low] + arr[high];
			if (sum == temp) {
				System.out.println(arr[low] + "  " + arr[high]);
				low++;
				high--;
			} else if (temp < sum)
				low++;
			else
				high--;
		}
	}

	public static void main(String[] args) {
		int[] arr = { -2, -1, 0, 3, 5, 6, 7, 9, 13, 14 };
		printEle(arr, 11);
	}
}
