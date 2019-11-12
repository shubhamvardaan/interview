package dynamicprogramming;

public class MaxSubStrLength {

	static int maxSubStringLengthDP(String str) {
		int n = str.length();
		int maxLen = -1;
		int[][] table = new int[n][n];
		for (int i = 0; i < n; i++) {
			table[i][i] = str.charAt(i) - '0';
		}
		for (int len = 2; len <= n; len++) {
			for (int i = 0; i < n - len + 1; i++) {
				int j = len + i - 1;
				int k = len / 2;
				table[i][j] = table[i][j - k] + table[j - k + 1][j];
				if (len % 2 == 0 && table[i][j - k] == table[j - k + 1][j] && maxLen < len) {
					maxLen = len;
				}
			}
		}

		return maxLen;
	}

	public static void main(String[] args) {
		String str = "142421";
		System.out.println(maxSubStringLengthDP(str));
	}
}
