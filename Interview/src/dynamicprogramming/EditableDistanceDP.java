package dynamicprogramming;

public class EditableDistanceDP {

	static int min(int a, int b) {
		return a < b ? a : b;
	}

	static int minimum(int a, int b, int c) {
		return min(a, b) < c ? min(a, b) : c;
	}

	static int editableDistanceDP(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		int[][] table = new int[m + 1][n + 1];

		for (int i = 0; i <= n; i++) {
			table[0][i] = i;
		}
		for (int j = 0; j <= m; j++) {
			table[j][0] = j;
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					table[i][j] = table[i - 1][j - 1];
				} else {
					table[i][j] = 1+minimum(table[i - 1][j - 1], table[i - 1][j], table[i][j - 1]);
				}
			}
		}
		return table[m][n];
	}

	public static void main(String[] args) {
		String s1 = "shubham";
		String s2 = "vardaan";
		System.out.println(editableDistanceDP(s1, s2));
	}
}
