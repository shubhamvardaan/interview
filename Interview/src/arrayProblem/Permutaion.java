package arrayProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutaion {

	static private void permutations(int[] arr, int start, List<int[]> results) {
		if (start >= arr.length) {
			if (!results.contains(arr))
				results.add(arr.clone());
		} else {
			for (int i = start; i < arr.length; i++) {
				swap(arr, i, start);
				permutations(arr, start + 1, results);
				swap(arr, i, start);
			}
		}
	}

	static List<int[]> permutations(int[] arr) {
		List<int[]> results = new ArrayList<>();
		int start = 0;
		permutations(arr, start, results);
		return results;
	}

	static void swap(int[] arr, int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 1 };
		for (int[] arr1 : permutations(arr))
			System.out.println(Arrays.toString(arr1));
	}
}
