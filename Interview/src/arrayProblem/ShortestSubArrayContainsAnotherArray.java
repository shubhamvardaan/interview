package arrayProblem;

import java.util.HashMap;
import java.util.Map;

public class ShortestSubArrayContainsAnotherArray {

	public static void setFalse(Map<Integer, Boolean> shubham, int[] small) {
		for (int i = 0; i < small.length; i++)
			shubham.put(small[i], false);
	}

	public static int getShortestSubArray(int[] big, int[] small) {
		if (big.length < small.length)
			return Integer.MAX_VALUE;
		Map<Integer, Boolean> shubham = new HashMap<>();
		int k = small.length;
		int min = Integer.MAX_VALUE;
		int shubham1 = 0, shubham2 = 0;
		int i, j = 0;
		setFalse(shubham, small);
		int count = 0;
		for (i = 0; i < big.length; i++) {
			if (i > 1 && shubham.containsKey(big[i - 1])) {
				shubham.put(big[i - 1], false);
				count = count - 1;
			}
			for (j = i; j < big.length; j++) {
				int element = big[j];
				if (shubham.get(element) != null) {
					if (shubham.get(element) == false) {
						shubham.put(element, true);
						count++;
					}
				}
				if (j - i < k)
					j = shubham2;
				if (count == k && min > j - i) {
					min = j - i + 1;
					shubham1 = i;
					shubham2 = j;
					break;
				}
			}
		}
		System.out.println(shubham1 + "  " + shubham2);
		return min;
	}

	public static void main(String[] args) {
		int[] big = { 7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1 };
		int[] small = { 1, 5, 9 };
		System.out.println(getShortestSubArray(big, small));
	}
}
