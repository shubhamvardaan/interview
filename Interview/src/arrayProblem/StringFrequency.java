package arrayProblem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringFrequency {
	static class shubham implements Comparator<Map.Entry<String, Integer>> {

		@Override
		public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
			return o1.getValue().compareTo(o2.getValue());
		}

	}

	public static String getKFrequentString(String[] array, int k) {
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < array.length; i++) {
			if (!map.containsKey(array[i])) {
				map.put(array[i], 1);
			} else {
				int temp = map.get(array[i]);
				map.put(array[i], temp + 1);
			}
		}
		List<Map.Entry<String, Integer>> t = new ArrayList<>(map.entrySet());
		t.sort(new shubham());
		for (Map.Entry<String, Integer> x : t) {
			if (x.getValue() == k)
				return x.getKey();
		}
		return "";
	}

	public static void main(String[] args) {
		String[] array = { "shubham", "test", "mangal", "vardaan", "test", "shubham", "shubham", "mangal", "mangal",
				"test", "1", "shubham", "mangal", "shubham", "mangal", "kumar", "kumar", "test", "ankur" };
		System.out.println(getKFrequentString(array, 2));
	}

}
