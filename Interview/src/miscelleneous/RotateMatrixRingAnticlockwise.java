package miscelleneous;

public class RotateMatrixRingAnticlockwise {

	private static int[] rotateMatrixByK(int[][] matrix, int M, int N, int K) {

		int p = 0;// start row index
		int m = M;// end row index

		int q = 0; // start column index
		int n = N;// end column index

		int[] temp = new int[M * N];
		int tempIndx = 0;
		int start = 0;
		int end = 0;

		while (p < m && q < n) {

			// copy first row of matrix
			for (int i = q; i < n; ++i) {
				temp[tempIndx++] = matrix[p][i];
				end++;
			}
			p++;

			// copy last column of matrix
			for (int i = p; i < m; ++i) {
				temp[tempIndx++] = matrix[i][n - 1];
				end++;
			}
			n--;

			// copy last row of matrix
			if (p < m) {
				for (int i = n - 1; i >= q; --i) {
					temp[tempIndx++] = matrix[m - 1][i];
					end++;
				}
				m--;
			}

			// copy first column of matrix
			if (q < n) {
				for (int i = m - 1; i >= p; --i) {
					temp[tempIndx++] = matrix[i][q];
					end++;
				}
				q++;
			}

			if (end - start > K) {
				reverse(temp, start, start + K - 1);
				reverse(temp, start + K, end - 1);
				reverse(temp, start, end - 1);
				start = end;
			} else {
				break;
			}

		}
		return temp;
	}

	private static void reverse(int[] array, int start, int end) {
		while (start <= end) {

			int temp = array[start];
			array[start] = array[end];
			array[end] = temp;

			// array[start] ^= array[end];
			// array[end] ^= array[start];
			// array[start] ^= array[end];

			start++;
			end--;
		}
	}

	private static void fillSpiral(int[][] array, int[] temp, int M, int N) {

		// rows
		int p = 0;
		int m = M;

		// columns
		int q = 0;
		int n = N;

		int indx = 0;

		while (p < m && q < n) {
			// fill first row

			for (int i = q; i < n; ++i) {
				array[p][i] = temp[indx++];
			}
			p++;

			// fill last column
			for (int i = p; i < m; ++i) {
				array[i][n - 1] = temp[indx++];
			}
			n--;

			// fill last row
			if (p < m) {
				for (int i = n - 1; i >= q; --i) {
					array[m - 1][i] = temp[indx++];
				}
				m--;
			}

			// fill first column
			if (q < n) {
				for (int i = m - 1; i >= p; --i) {
					array[i][q] = temp[indx++];
				}
				q++;
			}

		}
	}

	public static void main(String[] args) {

		int[][] array = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + "  ");
			}
			System.out.println();
		}

		System.out.println("----------After rotating-------------------");

		int[] rotatedArray = rotateMatrixByK(array, 4, 4, 4);
		fillSpiral(array, rotatedArray, 4, 4);

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}
}
