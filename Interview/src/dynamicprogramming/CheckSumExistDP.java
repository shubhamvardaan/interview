package dynamicprogramming;

public class CheckSumExistDP {
	static boolean sumExist(int[] a, int sum) {
		int rowNumber = sum + 1;
		int colNumber = a.length + 1;
		boolean[][] t = new boolean[rowNumber][colNumber];
		for (int i = 1; i < rowNumber; i++)
			t[i][0] = false;
		for (int j = 0; j < colNumber; j++)
			t[0][j] = true;
		for (int i = 0; i < rowNumber; i++) {
			for (int j = 1; j < colNumber; j++) {
				if (t[i][j - 1] == true) {
					t[i][j] = true;
					if ((i + a[j - 1]) < rowNumber) {
						t[i + a[j - 1]][j] = true;
					}
				} else if (t[i][j] != true)
					t[i][j] = false;
			}
		}
		return t[rowNumber - 1][colNumber - 1];
	}

	public static void main(String[] args) {
		int arr[] = { 2, 4, 5, 8 };
		int sum = 10;
		System.out.println(sumExist(arr, sum));
	}
}
