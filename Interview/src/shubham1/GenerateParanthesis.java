package shubham1;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {

	static void parenUtil(int left, int right, int index, char[] array, List<String> results) {
		if (left < 0 || right < left)
			return;
		if (left == 0 && right == 0)
			results.add(String.valueOf(array));
		else {
			array[index] = '(';
			parenUtil(left - 1, right, index + 1, array, results);

			array[index] = ')';
			parenUtil(left, right - 1, index + 1, array, results);

		}
	}

	static List<String> generateParenthesisList(int x) {
		int left = x;
		int right = x;
		List<String> results = new ArrayList<>();
		char[] array = new char[2 * x];
		parenUtil(left, right, 0, array, results);
		return results;
	}

	public static void main(String[] args) {
		for (String str : generateParenthesisList(2)) {
			System.out.println(str);
		}
	}
}
