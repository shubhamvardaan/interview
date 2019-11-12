package arrayProblem;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstRepeatedArray {
	static int getFirstRepeated(int[] arr) {
		int n = arr.length;
		Map<Integer, Integer> map = new LinkedHashMap<>();
		for (int i = 0; i < n; i++) {
			if (map.get(arr[i]) == null)
				map.put(arr[i], 1);
			else {
				int temp = map.get(arr[i]);
				map.put(arr[i], temp + 1);
			}
		}

		for (Map.Entry<Integer, Integer> temp : map.entrySet()) {
			if (temp.getValue() > 1)
				return temp.getKey();
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 5, 3, 4, 3, 5, 10, 55, 10 };
		System.out.println(getFirstRepeated(array));
	}
}
