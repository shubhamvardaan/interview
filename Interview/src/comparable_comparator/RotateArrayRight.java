package comparable_comparator;

public class RotateArrayRight {

	// static void rotateArrayByone(int arr[]) {
	// int length = arr.length;
	// int temp = arr[length - 1];
	// for (int i = length - 1; i > 0; i--) {
	// arr[i] = arr[i - 1];
	//
	// }
	//
	// arr[0] = temp;
	// }

	static int[] rotateRightK(int arr[], int k) {
		int n = arr.length;
		int count = 0;
		while (k > 0) {
			int temp = arr[count];
			arr[count] = arr[n - k];
			arr[n - k] = temp;
			count++;
			k--;
		}
		return arr;
	}

	static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + "  ");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };
		printArray(rotateRightK(arr, 4));
	}

}
