package miscelleneous;

import java.util.ArrayList;
import java.util.List;

public class LIS_DP {

	static List<Integer> getMaxLengthList(List<List<Integer>> lists) {
		int maxLen = Integer.MIN_VALUE;
		List<Integer> temp = null;
		int len;
		for (List<Integer> list : lists) {
			len = list.size();
			if (maxLen < len) {
				maxLen = len;
				temp = list;
			}
		}

		return temp;
	}

	static List<Integer> lis(int[] arr) {
		int n = arr.length;
		List<List<Integer>> list = new ArrayList<>();
		for (int i = 0; i < n; i++)
			list.add(new ArrayList<>());
		list.get(0).add(arr[0]);
		int i, j;
		for (i = 1; i < n; i++) {
			for (j = 0; j < i; j++) {
				if (arr[j] < arr[i] && list.get(i).size() < list.get(j).size()) {
					list.get(i).clear();
					list.get(i).addAll(list.get(j));
				}
			}
			list.get(i).add(arr[i]);
		}

		return getMaxLengthList(list);
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 5, 10, 7, 8, 11, 12, -1 };
		for (int x : lis(arr)) {
			System.out.print(x + " ");
		}
	}
}
