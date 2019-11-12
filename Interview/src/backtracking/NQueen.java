package backtracking;

public class NQueen {

	static final int N = 8;
	static int count = 1;

	static void print(int table[][]) {

		System.out.println(count++);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(table[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println();
	}

	static boolean isSafe(int table[][], int row, int column) {
		for (int i = 0; i < column; i++) // check in row
			if (table[row][i] == 1)
				return false;

		for (int i = row, j = column; i >= 0 && j >= 0; i--, j--) { // check in upper diagonal
			if (table[i][j] == 1)
				return false;
		}

		for (int i = row, j = column; i < N && j >= 0; i++, j--) { // check in left lower diagonal
			if (table[i][j] == 1)
				return false;
		}
		return true;

	}

	static boolean solveNQueenUtil(int[][] table, int column) {
		if (column == N) {
			print(table);
			return true;
		}

		boolean result = false;
		for (int i = 0; i < N; i++) {
			if (isSafe(table, i, column)) {
				table[i][column] = 1;
				result = result || solveNQueenUtil(table, column + 1);
				table[i][column] = 0;
			}
		}
		return false;
	}

	static void solveNQueen() {
		int[][] table = new int[N][N];
		if (solveNQueenUtil(table, 0) == false)
			System.out.println("Solution doesn't exist");

	}

	public static void main(String args[]) {
		solveNQueen();
	}

}
