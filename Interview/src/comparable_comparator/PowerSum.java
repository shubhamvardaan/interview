package comparable_comparator;

public class PowerSum {

	static class test {
		int count = 0;
	}

	static int power(int x, int n) {
		if (n == 0)
			return 1;
		if (n % 2 == 0)
			return power(x, n / 2) * power(x, n / 2);

		return x * power(x, n - 1);
	}

	static void powerSumRecur(int X, int N, int sum, test t, int indi) {
		if (sum == 0) {
			t.count += 1;
			return;
		}

		for (int i = indi; i <= X; i++) {
			int number = power(i, N);
			indi = i + 1;
			if (number <= X)
				powerSumRecur(X, N, sum - number, t, indi);
		}
	}

	static int powerSum(int X, int N) {
		test t = new test();
		int sum = X;
		powerSumRecur(X, N, sum, t, 1);
		return t.count;
	}

	public static void main(String[] args) {
		System.out.println(powerSum(100, 3));
	}

}
