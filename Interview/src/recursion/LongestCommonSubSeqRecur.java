package recursion;

public class LongestCommonSubSeqRecur {

	static int maximum(int a, int b) {
		return a > b ? a : b;
	}

	static int longestCommonSubSeqRecur(String s1, String s2, int m, int n) {
		if (m == 0 || n == 0)
			return 0;
		if (s1.charAt(m) == s2.charAt(n))
			return 1 + longestCommonSubSeqRecur(s1, s2, m - 1, n - 1);
		return maximum(longestCommonSubSeqRecur(s1, s2, m - 1, n), longestCommonSubSeqRecur(s1, s2, m, n - 1));
	}

	public static void main(String[] args) {
		String s1 = "SHUBHAMVARDAAN";
		String s2 = "BAMDA";
		int m = s1.length();
		int n = s2.length();
		System.out.println(longestCommonSubSeqRecur(s1, s2, m - 1, n - 1));

	}

}
