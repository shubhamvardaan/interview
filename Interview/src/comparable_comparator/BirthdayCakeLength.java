package comparable_comparator;

import java.util.HashMap;
import java.util.Map;

public class BirthdayCakeLength {
	static int birthdayCakeCandles(int[] arr) {
		HashMap<Integer, Integer> mp = new HashMap<>();
		int temp = -1;
		for (int i = 0; i < arr.length; i++) {
			if (!mp.containsKey(arr[i]))
				mp.put(arr[i], 1);
			else {
				temp = mp.get(arr[i]);
				mp.put(arr[i], ++temp);
			}
		}
		int max = Integer.MIN_VALUE;
		int key = 0;
		for (Map.Entry<Integer, Integer> map : mp.entrySet()) {
			if (max < map.getValue()) {
				max = map.getValue();
				key = map.getKey();
			}

		}
		return key;
	}

	public static void main(String[] args) {
		int arr[] = { 3, 1, 2, 3 };
		System.out.println(birthdayCakeCandles(arr));
	}
}
