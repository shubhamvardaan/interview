package dynamicprogramming;

public class NumberOfPathDP {

	static int numberOfPathDP(int m, int n) {
		int table[][] = new int[m][n];
		for (int i = 1; i < m; i++)
			table[i][0] = 1;
		for (int j = 1; j < n; j++)
			table[0][j] = 1;
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				table[i][j] = table[i - 1][j] + table[i][j - 1];
			}
		}

		return table[m - 1][n - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(numberOfPathDP(3, 4));
	}

}
