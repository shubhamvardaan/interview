package matrix;

public class PrintMatrixZigZag {
	static void printLeftToRight(int[][] matrix, int row) {
		int length = matrix[0].length;
		for (int i = 0; i < length; i++) {
			System.out.print(matrix[row][i] + "  ");
		}
		System.out.println();
	}

	static void printRightToLeft(int[][] matrix, int row) {
		int length = matrix[0].length;
		for (int i = length - 1; i >= 0; i--) {
			System.out.print(matrix[row][i] + "  ");
		}
		System.out.println();
	}

	static void printMatrixZigZag(int[][] matrix) {
		int M = matrix.length;
		boolean flag = true;
		for (int i = 0; i < M; i++) {
			if (flag == true) {
				printLeftToRight(matrix, i);
				flag = false;
			} else {
				printRightToLeft(matrix, i);
				flag = true;
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		printMatrixZigZag(matrix);
	}

}
