package miscelleneous;

import java.util.Arrays;

public class AlmostSorted {
	static boolean isSorted(int[] arr) {
		for (int i = 1; i < arr.length; i++)
			if (arr[i - 1] > arr[i])
				return false;
		return true;
	}

	static void swap(int[] arr, int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}

	static void reverse(int[] arr, int x, int y) {
		while (x < y) {
			int temp = arr[x];
			arr[x] = arr[y];
			arr[y] = temp;
			x++;
			y--;
		}
	}

	static void almostSorted(int[] arr) {
		int temp[] = Arrays.copyOf(arr, arr.length);
		Arrays.sort(temp);
		int len = arr.length;
		int first = 0;
		int second = 0;
		for (int i = 0; i < len; i++) {
			if (arr[i] != temp[i]) {
				first = i;
				break;
			}
		}
		for (int i = len - 1; i >= 0; i--) {
			if (arr[i] != temp[i]) {
				second = i;
				break;
			}
		}
		swap(arr, first, second);
		if (isSorted(arr)) {
			System.out.println("yes");
			System.out.print("swap ");
			System.out.print(first + 1);
			System.out.print(" ");
			System.out.print(second + 1);
			return;
		}
		swap(arr, first, second);
		reverse(arr, first, second);
		if (isSorted(arr)) {
			System.out.println("yes");
			System.out.print("reverse ");
			System.out.print(first + 1);
			System.out.print(" ");
			System.out.print(second + 1);
			return;
		}
		reverse(arr, first, second);

		System.out.println("no");
	}

	public static void main(String[] args) {
		int[] arr = { 3,1,2 };
		almostSorted(arr);
	}
}
