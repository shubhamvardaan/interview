package recursion;

import java.util.Arrays;

public class Recursion_1 {

	static void generateStringWithNoConsucutive1Util(Integer[] arr, int k, int n) {
		if (n == k) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		if (arr[n - 1] == 0) {
			arr[n] = 0;
			generateStringWithNoConsucutive1Util(arr, k, n + 1);
			arr[n] = 1;
			generateStringWithNoConsucutive1Util(arr, k, n + 1);
		}
		if (arr[n - 1] == 1) {
			arr[n] = 0;
			generateStringWithNoConsucutive1Util(arr, k, n + 1);
		}
	}

	static void generateStringWithNoConsucutive1(int k) {
		if (k <= 0)
			return;
		Integer[] arr = new Integer[k];
		arr[0] = 0;
		generateStringWithNoConsucutive1Util(arr, k, 1);
		arr[0] = 1;
		generateStringWithNoConsucutive1Util(arr, k, 1);
	}

	public static void main(String[] args) {
		generateStringWithNoConsucutive1(3);
	}
}