package dynamicprogramming;

public class LongestCommonSubSeq {

	static int getMax(int a, int b) {
		return a < b ? b : a;
	}

	static int longestCommonSubSeq(String a, String b) {
		int len1 = a.length();
		int len2 = b.length();
		int cache[][] = new int[len1 + 1][len2 + 1];

		for (int i = 0; i <= len1; i++)
			cache[i][0] = 0;
		for (int j = 1; j <= len2; j++)
			cache[0][j] = 0;
		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				if (a.charAt(i - 1) == b.charAt(j - 1))
					cache[i][j] = 1 + cache[i - 1][j - 1];
				else
					cache[i][j] = getMax(cache[i][j - 1], cache[i - 1][j]);
			}
		}

		return cache[len1][len2];
	}

	public static void main(String[] args) {
		String a = "shubham";
		String b = "vshub";
		System.out.println(longestCommonSubSeq(a, b));
	}

}
