package shubham1;

import java.util.ArrayList;
import java.util.List;

public class Combination {
	static void combination(String str, String shubham, List<String> list) {
		if (str.length() == 0) {
			if (!list.contains(shubham))
				list.add(new String(shubham));
			return;
		}
		for (int i = 0; i < str.length(); i++) {
			combination(str.substring(0, i) + str.substring(i + 1, str.length()), shubham + str.charAt(i), list);

		}
	}

	static void print(List<String> list) {
		for (String t : list) {
			System.out.println(t);
		}
	}

	static void combination(String str) {
		String shubham = "";
		List<String> list = new ArrayList<>();
		combination(str, shubham, list);
		System.out.println(list);
		print(list);
	}

	public static void main(String[] args) {
		String str = "aaab";
		combination(str);
	}

}
