package arrayProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SortAnagram {
	static void makeMap(Map<String, List<String>> map, String str) {
		char[] temp = str.toCharArray();
		Arrays.sort(temp);
		String s = String.valueOf(temp);
		//System.out.println(map.get(str));
		if (map.get(s) == null)
			map.put(s, new ArrayList<>());
		map.get(s).add(str);

	}

	static String[] sortArray(String[] arr) {
		Map<String, List<String>> map = new LinkedHashMap<>();
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			makeMap(map, arr[i]);
		}

		int index = 0;
		for (Map.Entry<String, List<String>> list : map.entrySet()) {
			for (String s : list.getValue()) {
				arr[index] = s;
				index = index + 1;
			}
		}
		return arr;
	}

	static void print(String[] arr) {
		for (String s : arr) {
			System.out.print(s + "  ");
		}
	}

	public static void main(String[] args) {
		String[] array = { "apple", "banana", "carrot", "ele", "duck", "papel", "tarroc", "cudk", "eel", "lee" };
		print(sortArray(array));

	}
}
