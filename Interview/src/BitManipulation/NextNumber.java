package BitManipulation;

public class NextNumber {
	static int getSmallNumber(int number) {
		int x = number;
		int count = 0;
		for (int i = 0; i < 32; i++) {
			count = count + 1;
			if ((x & 3) == 2)
				break;
			x = x >>> 1;
		}
		int t1 = (1 << count - 1);
		number = number | t1;
		int t2 = ~(1 << count);
		number = number & t2;
		return number;
	}

	static int getBigNumber(int number) {
		int x = number;
		boolean flag = false;
		int count = 0;
		for (int i = 0; i < 32; i++) {

			if ((x & 1) == 1)
				flag = true;
			else {
				if (flag == true)
					break;
				else
					flag = false;
			}
			count = count + 1;
			x = x >>> 1;
		}
		int t1 = 1 << count;
		int t2 = ~(1 << count - 1);
		number = number | t1;
		number = number & t2;

		return number;
	}

	public static void main(String[] args) {
		System.out.println(getSmallNumber(907));
		System.out.println(getBigNumber(5));
	}
}
