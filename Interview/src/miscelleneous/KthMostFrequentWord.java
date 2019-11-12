package miscelleneous;

import java.util.Map;
import java.util.TreeMap;

public class KthMostFrequentWord {
	public static void main(String[] args) {
		Map<String, Character> map = new TreeMap<>();
		map.put("shubham", 'c');
		map.put("ankur", 'c');
		map.put("aam", 'c');
		map.put("boy", 'c');
		map.put("owl", 'k');

		for (Map.Entry<String, Character> mp : map.entrySet()) {
			System.out.println(mp.getKey());
		}
	}
}
