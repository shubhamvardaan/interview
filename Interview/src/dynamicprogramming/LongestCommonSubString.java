package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubString {
	static int longestCommonSubString(String a, String b) {
		int len1 = a.length();
		int len2 = b.length();
		int[][] cache = new int[len1][len2];
		int max = Integer.MIN_VALUE;
		List<String> results = new ArrayList<>();

		for (int i = 0; i < len1; i++) {
			for (int j = 0; j < len2; j++) {
				if (a.charAt(i) == b.charAt(j)) {
					if (i == 0 || j == 0)
						cache[i][j] = 1;
					else
						cache[i][j] = 1 + cache[i - 1][j - 1];
					if (max < cache[i][j]) {
						max = cache[i][j];
						results.add(a.substring(i - max + 1, i + 1));
					} else if (cache[i][j] == max) {
						results.add(a.substring(i - max + 1, i + 1));
					}
				}
			}

		}
		System.out.println(results);
		return max;
	}

	public static void main(String args[]) {
		String a = "testing";
		String b = "ting";
		System.out.println(longestCommonSubString(a, b));

	}

}
