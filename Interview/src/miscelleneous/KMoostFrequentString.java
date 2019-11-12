package miscelleneous;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KMoostFrequentString {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	static String kthMostFrequentString(String[] arr, int k) {
		HashMap<String, Integer> mp = new HashMap<>();
		int count = 0;
		for (String s : arr) {
			count = 1;
			if (mp.containsKey(s)) {
				count = mp.get(s);
				count++;
			}
			mp.put(s, count);
		}
		List<Map.Entry> list = new ArrayList(mp.entrySet());
		Collections.sort(list, new Comparator() {

			@Override
			public int compare(Object arg0, Object arg1) {
				Integer v1 = (Integer) ((Map.Entry) arg0).getValue();
				Integer v2 = (Integer) ((Map.Entry) arg1).getValue();
				return v1.compareTo(v2);
			}

		});

		return (String) list.get(k-1).getKey();
	}

	public static void main(String[] args) {
		String[] arr = { "this", "this", "sh", "sh", "parrot", "sh" };
		System.out.println(kthMostFrequentString(arr, 3));
	}
}
