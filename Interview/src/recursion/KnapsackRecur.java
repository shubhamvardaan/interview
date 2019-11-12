package recursion;

public class KnapsackRecur {

	static int max(int a, int b) {
		return a > b ? a : b;
	}

	static int knapSack(int W, int w[], int val[], int n) {
		if (W == 0 || n == 0)
			return 0;
		if (w[n - 1] > W)
			knapSack(W, w, val, n - 1);
		return max(val[n - 1] + knapSack(W - w[n - 1], w, val, n - 1), knapSack(W, w, val, n - 1));
	}

	public static void main(String[] args) {

		int val[] = { 60, 100, 120 };
		int wt[] = { 10, 20, 30 };
		int W = 50;
		System.out.println(knapSack(W, wt, val, val.length));
	}

}
