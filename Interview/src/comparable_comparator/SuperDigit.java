package comparable_comparator;

public class SuperDigit {
	static int recurSuperDigit(String number) {
		if (number.length() == 1)
			return Integer.parseInt(number);
		int count = recurSuperDigit(number.substring(0, number.length() - 1))
				+ Integer.parseInt(number.substring(number.length() - 1));
		return count;
	}

	static int superDigit(String n, int k) {
		String result = "";
		for (int i = 0; i < k; i++)
			result = n + result;

		int count = recurSuperDigit(result);
		while (count > 10) {
			count = recurSuperDigit(String.valueOf(count));
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(superDigit("4757362", 10000));
	}

}
