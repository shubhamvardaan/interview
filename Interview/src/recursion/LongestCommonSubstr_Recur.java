package recursion;

public class LongestCommonSubstr_Recur {

	static int max(int a, int b) {
		return a > b ? a : b;
	}

	static int longestCommonSubstrRecur(String s1, String s2, int m, int n, int count) {
		if (n == 0 || m == 0)
			return count;
		if (s1.charAt(m) == s2.charAt(n))
			count = 1 + longestCommonSubstrRecur(s1, s2, m - 1, n - 1, count);
		count = max(longestCommonSubstrRecur(s1, s2, m, n - 1, count),
				longestCommonSubstrRecur(s1, s2, m - 1, n, count));
		return count;
	}

	public static void main(String[] args) {
		String s1 = "ABCA";
		String s2 = "ABCD";
		System.out.println(longestCommonSubstrRecur(s1, s2, 3, 3, 0));

	}

}
