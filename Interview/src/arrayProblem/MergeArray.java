package arrayProblem;

public class MergeArray {

	final static int INVALID_NUM = Integer.MIN_VALUE;

	public static void mergeArrays(int[] A, int[] B) {
		int l1 = A.length;
		int l2 = B.length - 1;
		int index = 0;
		int i = 0;
		while (i < l1) {
			if (A[i] != INVALID_NUM)
				A[index++] = A[i];
			i++;
		}
		int j = l1 - 1;
		index--;
		while (index >= 0 && l2 >= 0) {
			if (A[index] > B[l2]) {
				A[j] = A[index];
				index--;
			} else {
				A[j] = B[l2];
				l2--;
			}
			j--;
		}

		while (index >= 0) {
			A[j] = A[index];
			j--;
			index--;
		}
		while (l2 >= 0) {
			A[j] = B[l2];
			l2--;
			index--;
		}

	}

	public static void print(int[] arr) {
		for (int x : arr) {
			System.out.print(x + "  ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] A = { -3, 5, INVALID_NUM, 7, INVALID_NUM, 10, INVALID_NUM, 11, INVALID_NUM };
		int[] B = { -1, 2, 6, 12 };
		print(A);
		print(B);
		mergeArrays(A, B);
		print(A);
	}
}
