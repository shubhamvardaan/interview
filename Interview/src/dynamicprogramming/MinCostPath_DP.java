package dynamicprogramming;

public final class MinCostPath_DP {

	static int min(int a, int b) {
		return a < b ? a : b;
	}

	static int minimum(int a, int b, int c) {
		return a < min(b, c) ? a : min(b, c);
	}

	static int minCostDP(int[][] cost, int m, int n) {
		int[][] table = new int[m][n];
		table[0][0] = cost[0][0];
		for (int i = 1; i <= m; i++) {
			table[i][0] = table[i - 1][0] + cost[i][0];
		}
		for (int i = 1; i <= m; i++) {
			table[0][i] = table[0][i - 1] + cost[0][i];
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {

				table[i][j] = minimum(table[i - 1][j - 1], table[i][j - 1], table[i - 1][j]) + cost[i][j];
			}
		}

		return table[m][n];

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
