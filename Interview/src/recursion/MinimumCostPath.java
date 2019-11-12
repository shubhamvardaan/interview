package recursion;

public class MinimumCostPath {

	static int minCost(int[][] table, int m, int n) {
		if (m == n || m == n - 1)
			return table[m][n];
		int minimumCost = Integer.MAX_VALUE;
		for (int i = m + 1; i < n; i++) {
			int temp = minCost(table, m, i) + minCost(table, i, n);
			if (temp < minimumCost) {
				minimumCost = temp;
			}
		}
		return minimumCost;

	}

	public static void main(String[] args) {
		int[][] table = { { 0, 10, 75, 94 }, { -1, 0, 35, 50 }, { -1, -1, 0, 80 }, { -1, -1, -1, 0 } };
		System.out.println(minCost(table, 0, 3));

	}

}
