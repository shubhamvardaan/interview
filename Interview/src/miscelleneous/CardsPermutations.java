package miscelleneous;

import java.util.ArrayList;
import java.util.List;

public class CardsPermutations {
	static void swap(int arr[], int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}

	static void permRecur(int[] arr, int low, int high, List<int[]> result) {
		if (low == high) {
			result.add(arr.clone());
			return;
		}
		for (int i = low; i <= high; i++) {
			swap(arr, low, i);
			permRecur(arr, low + 1, high, result);
			swap(arr, low, i);
		}

	}

	static void allPerm(int[] arr) {
		List<int[]> result = new ArrayList<>();
		permRecur(arr, 0, arr.length - 1, result);
		System.out.println(result);
		System.out.println(arr);
		if(result.contains(arr))
			System.out.println(arr);
	}

	public static void main(String[] args) {
		int[] shubham = { 1, 2, 3 };
		allPerm(shubham);
	}
}
