package shubham1;

public class NumberofCoins {

	static int[] coins = { 1, 2 };

	static int coins(int amount, int x) {
		if (amount == 0)
			return 1;
		if (amount < 0)
			return 0;
		int coinNum = 0;
		for (int coin = x; coin < coins.length; coin++) {
			coinNum += coins(amount - coins[coin], coin);
		}
		return coinNum;
	}

	static int coinsDP(int amount) {
		int[] arr = new int[amount + 1];
		arr[0] = 1;
		for (int coin : coins) {
			for (int i = 1; i <= amount; i++)
				if (coin <= i)
					arr[i] += arr[i - coin];
		}

		return arr[amount];
	}

	public static void main(String[] args) {
		System.out.println(coins(4, 0));
		System.out.println(coinsDP(4));
	}
}
