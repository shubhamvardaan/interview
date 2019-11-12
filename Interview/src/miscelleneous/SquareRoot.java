package miscelleneous;

public class SquareRoot {

	static float squareRoot(int number, int precision) {
		int start = 0, end = number;
		int mid;
		float ans = 0F;
		while (start <= end) {
			mid = (start + end) / 2;
			if (mid * mid == number) {
				ans = mid;
				break;
			} else if (mid * mid < number) {
				start = mid + 1;
				ans = mid;
			} else
				end = mid - 1;
		}

		float increment = 0.1F;
		for (int i = 0; i < precision; i++) {
			while (ans * ans <= number) {
				ans += increment;
			}

			// loop terminates when ans * ans > number
			ans = ans - increment;
			increment = increment / 10;
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(squareRoot(50, 3));
	}

}
