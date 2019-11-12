package dynamicprogramming;

public class MaxSubMatrixWithAll1 {
	static int minValue(int a, int b) {
		return a < b ? a : b;
	}

	static int matrixwithAllOnes(int[][] t) {
		int m = t.length;
		int n = t[0].length;
		int max = Integer.MIN_VALUE;
		int[][] t1 = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0) {
					t1[i][j] = t[i][j];
					max = max < t1[i][j] ? t1[i][j] : max;
				} else if (t[i][j] != 0) {
					t1[i][j] = 1 + minValue(t1[i - 1][j], minValue(t1[i][j - 1], t1[i - 1][j - 1]));
					max = max < t1[i][j] ? t1[i][j] : max;
				} else {
					t1[i][j] = 0;
				}

			}
		}
		return max;
	}

	public static void main(String[] args) {
		int matrix[][] = { { 1, 1, 0, 0, 1, 1 }, { 0, 0, 1, 0, 1, 1 }, { 1, 1, 1, 1, 1, 0 }, { 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1 }, { 0, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 1, 1 } };
		System.out.println(matrixwithAllOnes(matrix));

	}

}
