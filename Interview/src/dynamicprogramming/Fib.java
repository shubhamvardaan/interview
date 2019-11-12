package dynamicprogramming;

public class Fib {

	static int fibonacci(int n) {
		int[] arr = new int[n+1];
		for (int i = 0; i <= n; i++) {
			if (i == 0 || i == 1) {
				arr[i] = 1;
			} else {
				arr[i] = arr[i - 1] + arr[i - 2];
			}
		}

		return arr[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(fibonacci(10));
	}

}
