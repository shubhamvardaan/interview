package arrayProblem;

public class PrintMatrixSpiral {
	static final int M = 5;
	static final int N = 6;

	static void printMatrixSpiral(int matrix[][]) {
		int l = 0, r = 0, L = M - 1, R = N - 1;
		int dir = 0;
		int i;

		while (l <= L && r <= R) {
			if (dir == 0) {
				for (i = r; i <= R; i++)
					System.out.print(matrix[l][i] + " ");
				l++;
				dir = 1;
			} else if (dir == 1) {
				for (i = l; i <= L; i++)
					System.out.print(matrix[i][R] + " ");
				R--;
				dir = 2;

			} else if (dir == 2) {
				for (i = R; i >= r; i--)
					System.out.print(matrix[L][i] + " ");
				L--;
				dir = 3;

			} else if (dir == 3) {
				for (i = L; i >= l; i--)
					System.out.print(matrix[i][r] + " ");
				r++;
				dir = 0;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 }, { 13, 14, 15, 16, 17, 18 },
				{ 19, 20, 21, 22, 23, 24 }, { 25, 26, 27, 28, 29, 30 } };
		printMatrixSpiral(matrix);

	}

}
