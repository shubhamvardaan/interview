package comparable_comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AbsolutePermutation {

	static class Pair {
		int first;
		int second;

		Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}

	static void findMaximumSumInArray(int[] arr) {
		Arrays.sort(arr);
		int n = arr.length;
		int maxSum = arr[n - 1] + arr[n - 2];
		List<Pair> sumList = getList(arr, 0);
		sumList.addAll(getList(arr, -maxSum));
		print(sumList);

	}

	static List<Pair> getList(int[] arr, int sum) {
		List<Pair> list = new ArrayList<>();
		int i = 0;
		int j = arr.length - 1;
		while (i < j) {
			int temp = arr[i] + arr[j];
			if (temp == sum) {
				list.add(new Pair(arr[i], arr[j]));
				i++;
				j--;
			} else if (temp < sum) {
				i++;
			} else
				j--;
		}

		return list;
	}

	static void print(List<Pair> list) {
		for (Pair pair : list) {
			System.out.println(pair.first + " " + pair.second);
		}
	}

	public static void main(String[] args) {
		int[] arr = { -20, 4, -2, -4, 8, 6, 22, 10, -12 };
		findMaximumSumInArray(arr);
	}

}
