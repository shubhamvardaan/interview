package dynamicprogramming;

public class LargestPlusSignInMatrix {
	static final int N = 10;

	private static int min(int a, int b) {
		return a < b ? a : b;
	}

	static int minimum(int a, int b, int c, int d) {
		return min(min(a, b), min(c, d));
	}

	static int calculateSize(int[][] grid) {

		int[][] left = new int[N][N];

		int[][] right = new int[N][N];

		int[][] top = new int[N][N];

		int[][] bottom = new int[N][N];

		for (int i = 0; i < N; i++) {
			// initialize first row of top matrix
			top[0][i] = grid[0][i];

			// initialize last row of bottom matrix
			bottom[N - 1][i] = grid[N - 1][i];

			// initialize first column of left matrix
			left[i][0] = grid[i][0];

			// initialize last column of right matrix
			right[i][N - 1] = grid[i][N - 1];
		}

		// fill all cells of above four matrix
		for (int i = 0; i < N; i++) {
			for (int j = 1; j < N; j++) {
				// fill left matrix
				if (grid[i][j] == 1)
					left[i][j] = left[i][j - 1] + 1;

				// fill top matrix
				if (grid[j][i] == 1)
					top[j][i] = top[j - 1][i] + 1;

				// fill bottom matrix
				if (grid[N - 1 - j][i] == 1)
					bottom[N - 1 - j][i] = bottom[N - j][i] + 1;

				// fill right matrix
				if (grid[i][N - 1 - j] == 1)
					right[i][N - 1 - j] = right[i][N - j] + 1;
			}
		}

		// bar stores length of longest + found so far
		int bar = 0;

		// compute longest plus
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// find minimum of left(i, j), right(i, j), top(i, j), bottom(i, j)
				int len = minimum(top[i][j], bottom[i][j], left[i][j], right[i][j]);

				// largest + would be formed by a cell that has maximum value
				if (len - 1 > bar)
					bar = len - 1;
			}
		}

		return bar;
	}

	public static void main(String[] args) {
		int[][] grid = { { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
				{ 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 }, { 0, 0, 0, 0, 1, 0, 0, 1, 0, 0 }, { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 }, { 1, 0, 0, 0, 1, 0, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1, 1, 0, 0, 1, 1 },
				{ 1, 1, 0, 0, 1, 0, 1, 0, 0, 1 }, { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 } };
		int bar = calculateSize(grid);
		System.out.println(4 * bar + 1);
	}
}
