package shubham1;

import java.util.Random;

public class GenerateRandomArray {

	static void printArray(int[] array) {
		for (int x : array) {
			System.out.print(x + " ");
		}
		System.out.println();
	}

	static void swap(int[] array, int x, int y) {
		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}

	static void generate(int[] array) {
		Random random = new Random();
		for (int i = 0; i < array.length; i++) {
			int k = random.nextInt(i + 1);
			swap(array, i, k);
		}
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		printArray(array);
		generate(array);
		printArray(array);
	}

}
