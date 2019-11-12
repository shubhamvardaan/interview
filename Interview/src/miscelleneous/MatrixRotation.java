package miscelleneous;

public class MatrixRotation {

	static void printMat(int[][] grid) {
		int len1 = grid.length;
		int len2 = grid[0].length;
		for (int i = 0; i < len1; i++) {
			for (int j = 0; j < len2; j++)
				System.out.print(grid[i][j] + " ");
			System.out.println();
		}
		System.out.println();
	}

	static void rotateMatrix(int[][] grid) {
		int len1 = grid.length - 1;
		int len2 = grid[0].length - 1;

		int dir = 1; // 1 for bottom to up
						// 2 for right to left
						// 3 for up to bottom
						// 4 for left to right
		int temp = 0;
		int temp1 = 0;
		int temp2 = 0;
		while (len1 >= 0 && len2 >= 0) {
			if (dir == 1) {
				temp = grid[0][len2];
				for (int x = 1; x <= len1; x++)
					grid[x - 1][len2] = grid[x][len2];
				dir = 2;
			}
			if (dir == 2) {
				temp1 = grid[0][0];
				for (int x = 1; x <= len2; x++)
					grid[0][x - 1] = grid[0][x];
				grid[0][len2 - 1] = temp;
				dir = 3;
			}
			if (dir == 3) {
				temp2 = grid[len1][0];
				for (int x = len1; x > 1; x--) {
					grid[x][0] = grid[x - 1][0];
				}

				grid[1][0] = temp1;
				dir = 4;
			}
			if (dir == 4) {
				for (int x = len2; x > 1; x--)
					grid[len1][x] = grid[len1][x - 1];
				grid[len1][1] = temp2;
				break;
			}
		}
		return;
	}

	static void rotateMatrixK(int[][] grid, int k) {
		for (int i = 0; i <k; i++)
			rotateMatrix(grid);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
				{ 21, 22, 23, 24, 25 } };
		printMat(grid);
		rotateMatrixK(grid, 3);
		printMat(grid);
	}

}
