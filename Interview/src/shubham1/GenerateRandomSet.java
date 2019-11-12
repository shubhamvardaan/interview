package shubham1;

import java.util.Random;

public class GenerateRandomSet {
	static void printArray(int[] array) {
		for (int x : array) {
			System.out.print(x + "  ");
		}
		System.out.println();
	}

	static void swap(int[] array, int x, int y) {
		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}

	static int[] generateRandomSet(int[] array, int m) {
		int length = array.length;
		if (length < m)
			return null;
		int[] shubham = new int[m];
		int i;
		for (i = 0; i < m; i++)
			shubham[i] = array[i];
		Random rand = new Random();
		for (; i < length; i++) {
			int k = rand.nextInt(i + 1);
			if (k < m) {
				shubham[k] = array[i];
			}
		}
		return shubham;
	}

	public static void main(String[] args) {
		int array[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
		printArray(array);
		printArray(generateRandomSet(array, 8));
	}
}
