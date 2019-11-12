package dynamicprogramming;

public class KnapSackDP {
	static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	static int knapSack_DP(int W, int[] wt, int[] val, int n) {
		int i, w;
		int K[][] = new int[n + 1][W + 1];

		// Build table K[][] in bottom up manner
		for (i = 0; i <= n; i++) {
			for (w = 0; w <= W; w++) {
				if (i == 0 || w == 0)
					K[i][w] = 0;
				else if (wt[i - 1] <= w)
					K[i][w] = max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
				else
					K[i][w] = K[i - 1][w];
			}
		}

		return K[n][W];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int val[] = { 1, 5, 2 };
		int wt[] = { 1, 3, 2 };
		int W = 6;
		System.out.println(knapSack_DP(W, wt, val, val.length));

	}

}
